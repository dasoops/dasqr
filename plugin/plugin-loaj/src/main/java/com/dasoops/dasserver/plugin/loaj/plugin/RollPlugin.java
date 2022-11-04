package com.dasoops.dasserver.plugin.loaj.plugin;

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

        final String roll = "roll";
        final String endRoll = "endRoll";
        String prefix = LoajKeyEnum.ROLL.getKey() + ":" + event.getGroupId();

        if (super.matchPrefix(event.getMessage(), roll)) {

            int i = RandomUtil.randomInt(1, 101);

            String redisKey = prefix + ":" + event.getUserId();
            //获取群roll点集合
            Set<String> keys = stringRedisTemplate.keys(prefix);
            Assert.notNull(keys, () -> keys.forEach(key -> stringRedisTemplate.boundSetOps(key).expire(5L, TimeUnit.MINUTES)));
            //添加
            stringRedisTemplate.opsForSet().add(redisKey, String.valueOf(i));
            cqTemplate.sendGroupMsg(event.getGroupId(), CqCodeUtil.at(event.getUserId()) + "你roll到了: " + i, false);
        } else if (super.matchPrefix(event.getMessage(), endRoll)) {

            Set<String> keys = stringRedisTemplate.keys(prefix);
            //id对应最大值集合
            Map<String, Integer> resMap = new HashMap<>();

            Integer integer = stringRedisTemplate.opsForSet().members("key").stream().map(Integer::parseInt).max(Comparator.comparingInt(Integer::valueOf)).orElse(null);
            keys.stream().forEach(key -> {
                resMap.put(
                        key.substring(key.lastIndexOf(":")),
                        //取最大值
                        stringRedisTemplate.opsForSet().members("key").stream().map(Integer::parseInt).max(Comparator.comparingInt(Integer::valueOf)).orElse(null));
            });

            Map.Entry<String, Integer> maxEntry = resMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElse(null);

            String userId = maxEntry.getKey();
            Integer score = maxEntry.getValue();

            cqTemplate.sendGroupMsg(event.getGroupId(), StrUtil.format("{}恭喜这个B摇到了最高点:{}", CqCodeUtil.at(Long.valueOf(userId)), score), false);
            if (score <= 20) {
                cqTemplate.sendGroupMsg(event.getGroupId(), "不过,roll多次可不符合规则哦", false);
            }else if (){

            }

        }

        return super.onGroupMessage(cqTemplate, event);
    }
}
