package com.dasoops.dasserver.plugin.schedule.task;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.EventUtil;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.PostTypeEnum;
import com.dasoops.dasserver.plugin.schedule.entity.param.ShamMessageScheduleParam;
import com.dasoops.dasserver.plugin.shammessage.ShamMessageTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: ScheduleTask
 * @ClassPath com.dasoops.dasserver.plugin.schedule.task.ScheduleTask
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 安排任务
 */
@Component
@RequiredArgsConstructor
public class ScheduleTask {

    private final ShamMessageTemplate shamMessageTemplate;

    public void sendShamMessage(ShamMessageScheduleParam param) {
        Assert.getInstance().allMustNotNull(param, param.getMessage(), param.getGroupId());
        //selfId为空:所有
        Long xSelfId = param.getXSelfId();
        List<CqTemplate> cqTemplateList;
        if (xSelfId == null) {
            cqTemplateList = CqGlobal.getAll();
        } else {
            cqTemplateList = List.of(CqGlobal.get(xSelfId));
        }

        if (cqTemplateList == null || cqTemplateList.size() <= 0) {
            throw new LogicException(CqExceptionEnum.CQ_TEMPLATE_NO_CONNECTION);
        }

        String message = param.getMessage();
        Long groupId = param.getGroupId();
        Long userId = param.getUserId();

        CqMessageEvent event;
        if (param.getGroupId() != null) {
            CqGroupMessageEvent cqGroupMessageEvent = new CqGroupMessageEvent();
            cqGroupMessageEvent.setGroupId(groupId);
            event = cqGroupMessageEvent;
            event.setMessageType(EventTypeEnum.MESSAGE_GROUP.getKey());
        } else {
            event = new CqPrivateMessageEvent();
            event.setMessageType(EventTypeEnum.MESSAGE_PRIVATE.getKey());
        }
        event.setPostType(PostTypeEnum.MESSAGE.getKey());
        event.setMessage(message);
        event.setRawMessage(message);
        event.setUserId(userId);

        cqTemplateList.forEach(cqTemplate -> {
            event.setSelfId(cqTemplate.getSelfId());
            JSONObject eventJson = JSON.parseObject(JSON.toJSONString(event));
            EventUtil.set(eventJson);
            shamMessageTemplate.sendMsg(cqTemplate, eventJson);
        });
    }

}
