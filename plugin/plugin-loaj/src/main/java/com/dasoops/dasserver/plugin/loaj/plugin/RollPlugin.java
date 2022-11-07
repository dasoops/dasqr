package com.dasoops.dasserver.plugin.loaj.plugin;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.core.util.Assert;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.bot.PassObj;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajKeyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Title: rollPlugin
 * @ClassPath com.dasoops.dasserver.plugin.loaj.plugin.rollPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/04
 * @Version 1.0.0
 * @Description: roll点插件
 */
@Component
@Slf4j
public class RollPlugin extends CqPlugin {

    private final StringRedisTemplate stringRedisTemplate;

    public RollPlugin(@SuppressWarnings("all") StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    @SuppressWarnings("all")
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {

        final String prefix = LoajKeyEnum.ROLL.getKey() + ":" + event.getGroupId() + ":";
        final String roll = "roll";
        final String endRoll = "endRoll";

        if (super.matchPrefix(event.getMessage(), roll)) {
            //roll

            int i = RandomUtil.randomInt(1, 101);

            String redisKey = prefix + event.getUserId();
            //获取群roll点集合
            Set<String> keys = stringRedisTemplate.keys(prefix);
            //全部设置为5分钟过期
            Assert.notNull(keys, () -> keys.forEach(key -> stringRedisTemplate.boundSetOps(key).expire(5L, TimeUnit.MINUTES)));
            //添加
            stringRedisTemplate.opsForSet().add(redisKey, String.valueOf(i));
            cqTemplate.sendGroupMsg(event.getGroupId(), CqCodeUtil.at(event.getUserId()) + "你roll到了: " + i, false);

        } else if (super.matchPrefix(event.getMessage(), endRoll)) {
            //endRoll

            //根据前缀获取key集合
            Set<String> keys = stringRedisTemplate.keys(prefix + "*");
            //没有人roll直接短路
            if (ObjUtil.isEmpty(keys)) {
                cqTemplate.sendGroupMsg(event.getGroupId(), "还没有人roll点哦", false);
                return PassObj.pass(event);
            }
            if (!ObjUtil.isEmpty(keys)) {
                //id对应最大值集合
                Map<String, Integer> resMap = new HashMap<>(16);
                keys.forEach(key -> resMap.put(
                        key.substring(key.lastIndexOf(":") + 1),
                        Assert.notNull(stringRedisTemplate.opsForSet().members(key),
                                //取最大值
                                res -> res.stream().map(Integer::parseInt).max(Comparator.comparingInt(Integer::valueOf)).orElse(null))
                ));

                //获取最高分对象
                Map.Entry<String, Integer> maxEntry = resMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElse(null);
                String userId = maxEntry.getKey();
                Integer score = maxEntry.getValue();

                cqTemplate.sendGroupMsg(event.getGroupId(), StrUtil.format("{}恭喜这个B摇到了最高点:{}", CqCodeUtil.at(Long.valueOf(userId)), score), false);


                final Integer niggerScore = 20;
                Long size = stringRedisTemplate.opsForSet().size(prefix + userId);

                if (score <= niggerScore) {
                    if (size > 1) {
                        cqTemplate.sendGroupMsg(event.getGroupId(), StrUtil.format("投了{}次,整个{}分,乐,铁黑鬼",size,score), false);
                    }else {
                        cqTemplate.sendGroupMsg(event.getGroupId(), StrUtil.format("{}分,乐,什么黑鬼",score), false);
                    }
                }else if (resMap.size() <= 1) {
                    cqTemplate.sendGroupMsg(event.getGroupId(), "一个人玩roll点,乐", false);
                }else if (size > 1) {
                    cqTemplate.sendGroupMsg(event.getGroupId(), "不过,roll多次对别人可不太公平哦~", false);
                }

                stringRedisTemplate.delete(keys);
            }

        }

        return PassObj.block();
    }

}
