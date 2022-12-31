package com.dasoops.dasserver.plugin.exceptionwrapper;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import com.dasoops.dasserver.cq.exception.wrapper.ExceptionWrapper;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.cq.utils.EventUtil;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;
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

        ExceptionPo exceptionPo = new ExceptionPo();
        exceptionPo.setTime(new Date());
        //根据类型构建错误信息(自定义异常为已捕获)
        exceptionPo.setType(finalException.getExceptionEnum().getMsg());
        exceptionPo.setStackMessage(finalException.getStackMessage());
        exceptionPo = mongoTemplate.save(exceptionPo);

        //非web逻辑异常发送错误通知
        //这里不会有web异常!
        sendNoticeMsg(EventUtil.get(), exceptionPo);
    }

    private void sendNoticeMsg(EventInfo eventInfo, ExceptionPo exceptionPo) {
        CqTemplate cqTemplate = CqGlobal.findFirst().orElseThrow(() -> new CqLogicException(ExceptionEnum.NO_CQ_CONNECTION));
        //网页访问/定时任务 产生的异常汇报管理群
        if (EventUtil.isEmpty()) {
            cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), buildNoticeMsg(false, true, cqProperties, exceptionPo), false);
            return;
        }
        String messageType = eventInfo.getMessageType();
        switch (messageType) {
            case "private" ->
                    //私聊发送
                    cqTemplate.sendPrivateMsg(eventInfo.getAuthorId(), buildNoticeMsg(false, false, eventInfo, exceptionPo), false);
            case "group" ->
                    //群聊at
                    cqTemplate.sendGroupMsg(eventInfo.getGroupId(), buildNoticeMsg(true, false, eventInfo, exceptionPo), false);
            case "httpRequest" ->
                    //群聊atAdmin
                    cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), buildNoticeMsg(true, true, eventInfo, exceptionPo), false);
            default ->
                    //群聊普通消息
                    cqTemplate.sendGroupMsg(eventInfo.getGroupId(), buildNoticeMsg(false, true, eventInfo, exceptionPo), false);
        }
    }

    private String buildNoticeMsg(boolean hasAt, boolean isAdminNotice, EventInfo eventInfo, ExceptionPo exceptionPo) {
        String msgTemplate = "{}消息解析发生异常{}\r\ntype: {}\r\nmessageId: {}\r\nerrorId: {}";
        String msg = StrUtil.format(msgTemplate,
                hasAt ? CqCodeUtil.at(eventInfo.getAuthorId()) : "",
                isAdminNotice ? "(此条为管理群通知)" : "",
                exceptionPo.getType(),
                eventInfo.getMessageId(),
                exceptionPo.getId().toHexString()
        );
        return msg;
    }

    @SuppressWarnings("all")
    private String buildNoticeMsg(boolean hasAt, boolean isAdminNotice, CqProperties cqProperties, ExceptionPo exceptionPo) {
        String msgTemplate = "{}消息解析发生异常{}\r\ntype: {}\r\nerrorId: {}";
        String msg = StrUtil.format(msgTemplate,
                hasAt ? CqCodeUtil.at(cqProperties.getDevUserId()) : "",
                isAdminNotice ? "(此条为管理群通知)" : "",
                exceptionPo.getType(),
                exceptionPo.getId().toHexString()
        );
        return msg;
    }
}
