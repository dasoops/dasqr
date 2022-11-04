package com.dasoops.dasserver.plugin.exceptionwrapper;

import cn.hutool.core.util.StrUtil;
import com.dasoops.core.entity.enums.ExceptionEnum;
import com.dasoops.core.exception.BaseCustomException;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.conf.AsyncMongoTemplate;
import com.dasoops.dasserver.cq.exception.wrapper.ExceptionWrapper;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.cq.utils.EventUtil;
import com.dasoops.dasserver.cq.utils.entity.EventInfo;
import org.bson.types.ObjectId;
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
public class CustomExceptionWrapper implements ExceptionWrapper {

    private final MongoTemplate mongoTemplate;

    public CustomExceptionWrapper(@SuppressWarnings("all") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void invoke(Exception e) {

        BaseCustomException finalException;
        if (e instanceof BaseCustomException) {
            finalException = (BaseCustomException) e;
        } else {
            finalException = new BaseCustomException(e);
        }

        ExceptionPo exceptionPo = new ExceptionPo();
        exceptionPo.setTime(new Date());
        //根据类型构建错误信息(自定义异常为已捕获)
        exceptionPo.setType(finalException.getExceptionEnum().getMsg());
        exceptionPo.setStackMessage(finalException.getStackMessage());
        ExceptionPo res = mongoTemplate.save(exceptionPo);

        //发送错误通知
        //todo 待改进
        sendNoticeMsg(EventUtil.get(),res.getObjectId());

    }

    private void sendNoticeMsg(EventInfo eventInfo,ObjectId objectId) {
        CqTemplate cqTemplate = CqGlobal.findFirst().orElseThrow(() -> new BaseCustomException(ExceptionEnum.NO_CQ_CONNECTION));
        String messageType = eventInfo.getMessageType();

        switch (messageType) {
            case "private":
                //私聊发送
                cqTemplate.sendPrivateMsg(eventInfo.getAuthorId(), buildNoticeMsg(false, false, eventInfo, objectId), false);
                break;
            case "group":
                //群聊at
                cqTemplate.sendGroupMsg(eventInfo.getAuthorId(), buildNoticeMsg(true, false, eventInfo, objectId), false);
                break;
            case "httpRequest":
                //群聊atAdmin
                cqTemplate.sendGroupMsg(eventInfo.getAuthorId(), buildNoticeMsg(true, true, eventInfo, objectId), false);
                break;
            default:
                //群聊普通消息
                cqTemplate.sendGroupMsg(eventInfo.getAuthorId(), buildNoticeMsg(false, true, eventInfo, objectId), false);
                break;
        }
    }

    private String buildNoticeMsg(boolean hasAt, boolean isAdminNotice, EventInfo eventInfo, ObjectId objectId) {
        String msgTemplate = "{}消息解析发生异常{}\r\nmessageId:{}\r\nerrorId:{}";
        String msg = StrUtil.format(msgTemplate,
                hasAt ? CqCodeUtil.at(eventInfo.getAuthorId()) : null,
                isAdminNotice ? "(此条为管理群通知)" : null,
                eventInfo.getMessageId(),
                objectId.toHexString()
        );
        return msg;
    }
}
