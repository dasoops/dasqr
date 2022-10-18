package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other;

import cn.hutool.core.util.RandomUtil;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.dq.methodstrategy.entity.enums.DqRedisKeyEnum;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Title: RollStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.game.RollStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: roll点策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
public class RollStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Override
    public Long getId() {
        return 1580000677790355458L;
    }

    @Override
    public void invoke(List<String> params) {
        EventInfo eventInfo = EventUtil.get();
        boolean isGroup = EventUtil.isGroup();

        int i = RandomUtil.randomInt(1, 101);
        if (isGroup) {
            String redisKey = DqRedisKeyEnum.ROLL_ID_GET_POINT_MAP.getRedisKey() + ":" + eventInfo.getGroupId();
            redisTemplate.boundHashOps(redisKey).expire(5L, TimeUnit.MINUTES);
            redisTemplate.opsForHash().put(redisKey, String.valueOf(eventInfo.getAuthorId()), String.valueOf(i));
        }

        cqService.sendMsg("你roll到了: " + i);
    }
}
