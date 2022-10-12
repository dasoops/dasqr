package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.game;

import cn.hutool.core.util.RandomUtil;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.util.CqKeywordUtil;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.methodstrategy.entity.enums.DqRedisKeyEnum;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Title: RollStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.game.RollStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: 结束roll点策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
public class EndRollStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    StringRedisTemplate redisTemplate;

    @Override
    public Long getId() {
        return 1580000664561520641L;
    }

    @Override
    public void invoke(List<String> params) {
        EventInfo eventInfo = EventUtil.get();
        boolean isGroup = String.valueOf(eventInfo.getMessageType()).equals(CqKeywordEnum.MESSAGE_TYPE_GROUP.getOtherName());

        if (!isGroup) {
            cqService.sendMsg("私聊暂时不支持统计哦!");
        }

        String redisKey = DqRedisKeyEnum.ROLL_ID_GET_POINT_MAP.getRedisKey() + ":" + eventInfo.getGroupId();
        Map<String, Integer> rollMap = redisTemplate.opsForHash().entries(redisKey).entrySet().stream().collect(Collectors.toMap(
                res -> String.valueOf(res.getKey()),
                res -> Integer.valueOf(String.valueOf(res.getValue()))
        ));

        Map.Entry<String, Integer> entry = rollMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).orElseThrow(() -> new LogicException(ExceptionCodeEnum.PARAMETER_GET_ERROR));
        String id = entry.getKey();
        Integer maxPoint = entry.getValue();

        redisTemplate.delete(redisKey);
        cqService.sendMsg(CqKeywordUtil.buildAtCqCode(id) + "恭喜这个B摇到了最高点: " + maxPoint);
    }
}
