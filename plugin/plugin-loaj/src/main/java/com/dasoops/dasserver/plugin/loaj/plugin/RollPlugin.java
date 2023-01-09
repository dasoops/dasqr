package com.dasoops.dasserver.plugin.loaj.plugin;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.loaj.cache.RollCache;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajConfigHashKeyEnum;
import com.dasoops.dasserver.plugin.loaj.entity.param.EndRollParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.RollParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
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
@RequiredArgsConstructor
public class RollPlugin extends CqPlugin {

    private final RollCache rollCache;
    private final ConfigCache configCache;

    final String rollPrefix = "roll";

    @MessageMapping(prefix = "endRoll", type = MessageMappingTypeEnum.GROUP)
    public PassObj endRoll(CqTemplate cqTemplate, EndRollParam param) {
        log.debug("(RollPlugin) 进入endRoll点逻辑");
        Long groupId = param.getGroupId();

        //没有人roll直接短路
        if (!rollCache.hasRecord(groupId)) {
            cqTemplate.sendGroupMsg(param.getGroupId(), "还没有人roll点哦", false);
            log.debug("(RollPlugin) endRoll逻辑执行完毕,阻塞后续插件 - 无人roll点分支");
            return PassObj.block();
        }

        //id对应最大值集合
        Map<Long, Set<Integer>> allRecordGroupingByUserId = rollCache.getAllRecord(groupId);

        //分组每人最高分
        Map<Long, Integer> maxScoreByUserIdMap = allRecordGroupingByUserId.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> entry.getValue().stream().max(Comparator.comparingInt(Integer::intValue)).orElseThrow(() -> new LogicException(ExceptionEnum.UN_EXPECTED))
        ));

        //最高分对象
        Map.Entry<Long, Integer> maxScoreEntry = maxScoreByUserIdMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get();

        Long userId = maxScoreEntry.getKey();
        Integer score = maxScoreEntry.getValue();

        cqTemplate.sendGroupMsg(param.getGroupId(), StrUtil.format("{}恭喜这个B摇到了最高点:{}", CqCodeUtil.at(userId), score), false);


        int userTotal = allRecordGroupingByUserId.size();

        if (score <= configCache.getIntegerConfig(LoajConfigHashKeyEnum.ROLL_NIGGER_SCORE)) {
            if (userTotal > 1) {
                cqTemplate.sendGroupMsg(groupId, StrUtil.format("投了{}次,整个{}分,乐,铁黑鬼", userTotal, score), false);
            } else {
                cqTemplate.sendGroupMsg(groupId, StrUtil.format("{}分,乐,什么黑鬼", score), false);
            }
        } else if (userTotal <= 1) {
            cqTemplate.sendGroupMsg(groupId, "一个人玩roll点,乐", false);
        } else {
            cqTemplate.sendGroupMsg(groupId, "不过,roll多次对别人可不太公平哦~", false);
        }

        rollCache.removeGroupAllRecord(groupId);
        log.info("(RollPlugin) endRoll逻辑执行完毕,阻塞后续插件");
        return PassObj.block();
    }

    @MessageMapping(prefix = rollPrefix, type = MessageMappingTypeEnum.GROUP)
    public PassObj roll(CqTemplate cqTemplate, RollParam param) {
        log.debug("(RollPlugin) 进入roll点逻辑");

        int randomInt = RandomUtil.randomInt(1, 101);
        Long groupId = param.getGroupId();

        //延长记录时间
        rollCache.lengthenGroupExpireTime(groupId);
        //添加记录
        rollCache.addRecord(param.getGroupId(), param.getUserId(), randomInt);
        //发消息
        cqTemplate.sendGroupMsg(groupId, CqCodeUtil.at(param.getUserId()) + "你roll到了: " + randomInt, false);

        log.info("(RollPlugin) roll点逻辑执行完毕,阻塞后续插件");
        return PassObj.block();
    }

}
