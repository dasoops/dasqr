package com.dasoops.dasserver.plugin.exceptionwrapper.wrapper;

import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.EventUtil;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.entity.enums.EventTypeEnum;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;
import com.dasoops.dasserver.cq.wrapper.ExceptionWrapper;
import com.dasoops.dasserver.plugin.exceptionwrapper.entity.dbo.ExceptionDo;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Title: CustomExceptionWrapper
 * @ClassPath com.dasoops.dasserver.plugin.exceptionwrapper.CustomExceptionWrapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/04
 * @Version 1.0.0
 * @Description: 自定义异常增强
 * @see ExceptionWrapper
 */
@Component
public class ExceptionWrapperImpl implements ExceptionWrapper {

    private final MongoTemplate mongoTemplate;
    private final CqProperties cqProperties;

    public ExceptionWrapperImpl(@SuppressWarnings("all") MongoTemplate mongoTemplate, CqProperties cqProperties) {
        this.mongoTemplate = mongoTemplate;
        this.cqProperties = cqProperties;
    }

    @Override
    public void invoke(Exception e) {

        CqLogicException finalException;
        if (e instanceof CqLogicException) {
            finalException = (CqLogicException) e;
        } else {
            finalException = new CqLogicException(e);
        }

        ExceptionDo exceptionDo = new ExceptionDo();
        exceptionDo.setTime(new Date());
        //根据类型构建错误信息(自定义异常为已捕获)
        exceptionDo.setType(finalException.getExceptionEnum().getMsg());
        exceptionDo.setStackMessage(finalException.getStackMessage());
        exceptionDo = mongoTemplate.save(exceptionDo);

        //非web逻辑异常发送错误通知
        //这里不会有web异常!
        sendNoticeMsg(EventUtil.get(), exceptionDo);
    }

    private void sendNoticeMsg(EventInfo eventInfo, ExceptionDo exceptionDo) {
        CqTemplate cqTemplate = CqGlobal.findFirst().orElseThrow(() -> new CqLogicException(CqExceptionEnum.CQ_GLOBAL_EMPTY));
        //网页访问/定时任务 产生的异常汇报管理群
        if (EventUtil.isEmpty()) {
            cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), buildNoticeMsg(false, true, cqProperties, exceptionDo), false);
            return;
        }
        String messageType = eventInfo.getMessageType();
        EventTypeEnum eventTypeEnum = EnumUtil.getBy(EventTypeEnum::getKey, messageType);
        switch (eventTypeEnum) {
            case MESSAGE_PRIVATE ->
                    //私聊发送
                    cqTemplate.sendPrivateMsg(eventInfo.getAuthorId(), buildNoticeMsg(false, false, eventInfo, exceptionDo), false);
            case MESSAGE_GROUP ->
                    //群聊at
                    cqTemplate.sendGroupMsg(eventInfo.getGroupId(), buildNoticeMsg(true, false, eventInfo, exceptionDo), false);
            default ->
                    //群聊普通消息
                    cqTemplate.sendGroupMsg(eventInfo.getGroupId(), buildNoticeMsg(false, true, eventInfo, exceptionDo), false);
        }
    }

    private String buildNoticeMsg(boolean hasAt, boolean isAdminNotice, EventInfo eventInfo, ExceptionDo exceptionDo) {
        String msgTemplate = "{}消息解析发生异常{}\r\ntype: {}\r\nmessageId: {}\r\nerrorId: {}";
        String msg = StrUtil.format(msgTemplate,
                hasAt ? CqCodeUtil.at(eventInfo.getAuthorId()) : "",
                isAdminNotice ? "(此条为管理群通知)" : "",
                exceptionDo.getType(),
                eventInfo.getMessageId(),
                exceptionDo.getId().toHexString()
        );
        return msg;
    }

    @SuppressWarnings("all")
    private String buildNoticeMsg(boolean hasAt, boolean isAdminNotice, CqProperties cqProperties, ExceptionDo exceptionDo) {
        String msgTemplate = "{}消息解析发生异常{}\r\ntype: {}\r\nerrorId: {}";
        String msg = StrUtil.format(msgTemplate,
                hasAt ? CqCodeUtil.at(cqProperties.getDevUserId()) : "",
                isAdminNotice ? "(此条为管理群通知)" : "",
                exceptionDo.getType(),
                exceptionDo.getId().toHexString()
        );
        return msg;
    }

    @Override
    public Integer getOrder() {
        return 10;
    }
}
