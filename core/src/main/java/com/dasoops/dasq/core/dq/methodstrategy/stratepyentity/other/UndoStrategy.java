package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other;

import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.dq.methodstrategy.entity.enums.DqRedisKeyEnum;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: UndoStrategy
 * @ClassPath com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other.UndoStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/19
 * @Version 1.0.0
 * @Description: 撤销策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
public class UndoStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {


    @Override
    public Long getId() {
        return 1582619904835649537L;
    }

    @Override
    public void invoke(List<String> params) {
        EventInfo eventInfo = EventUtil.get();
        Long groupId = eventInfo.getGroupId();
        String messageId = (String) redisTemplate.opsForHash().get(DqRedisKeyEnum.UNDO.getRedisKey(), String.valueOf(groupId));
        if (messageId == null) {
            cqService.sendMsg("没有丢人消息捏");
            return;
        }
        cqService.sendMsg(cqService.getMessage(messageId));
    }
}
