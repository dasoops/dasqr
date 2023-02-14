package com.dasoops.dasserver.plugin.loaj.plugin;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.result.PluginResult;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.loaj.cache.RollCache;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajConfigHashKeyEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @title: rollPlugin
 * @classPath com.dasoops.dasserver.plugin.loaj.plugin.rollPlugin
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/04
 * @version 1.0.0
 * @description roll点插件
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RollPlugin extends CqPlugin {



    private final RollCache rollCache;
    private final ConfigCache configCache;

    @MessageMapping(equal = "endRoll", type = MessageMappingTypeEnum.GROUP)
    public PluginResult endRoll(CqTemplate cqTemplate, MessageParam<SimpleParam> param) {
        log.debug("(RollPlugin) 进入endRoll点逻辑");
        Long groupId = param.getGroupId();

        //没有人roll直接短路
        if (!rollCache.hasRecord(groupId)) {
            log.debug("(RollPlugin) endRoll逻辑执行完毕,阻塞后续插件 - 无人roll点分支");
            return PluginResult.of("还没有人roll点哦");
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

        PluginResult result = PluginResult.of(StrUtil.format("{}恭喜这个B摇到了最高点:{}", CqCodeUtil.at(userId), score));

        int userTotal = allRecordGroupingByUserId.size();
        //黑鬼 | 一个人 | 多次 只能触发一个
        if (score <= configCache.getIntegerConfig(LoajConfigHashKeyEnum.ROLL_NIGGER_SCORE)) {
            if (userTotal > 1) {
                result.add(StrUtil.format("投了{}次,整个{}分,乐,铁黑鬼", userTotal, score));
            } else {
                result.add(StrUtil.format("{}分,乐,什么黑鬼", score));
            }
        } else if (userTotal <= 1) {
            result.add("一个人玩roll点,乐");
        } else if (allRecordGroupingByUserId.get(maxScoreEntry.getKey()).size() > 1) {
            result.add("不过,roll多次对别人可不太公平哦~");
        }

        rollCache.removeGroupAllRecord(groupId);
        log.info("(RollPlugin) endRoll逻辑执行完毕,阻塞后续插件");
        return result;
    }

    final String rollPrefix = "roll";

    @MessageMapping(equal = rollPrefix, type = MessageMappingTypeEnum.GROUP)
    public String roll(CqTemplate cqTemplate, MessageParam<SimpleParam> param) {
        log.debug("(RollPlugin) 进入roll点逻辑");

        int randomInt = RandomUtil.randomInt(1, 101);
        Long groupId = param.getGroupId();

        //延长记录时间
        rollCache.lengthenGroupExpireTime(groupId);
        //添加记录
        rollCache.addRecord(param.getGroupId(), param.getUserId(), randomInt);

        log.info("(RollPlugin) roll点逻辑执行完毕,阻塞后续插件");
        return CqCodeUtil.at(param.getUserId()) + "你roll到了: " + randomInt;
    }
}