package com.dasoops.dasserver.plugin.exceptionwrapper.plugin;

import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.utils.DqCodeUtil;
import com.dasoops.dasserver.plugin.exceptionwrapper.entity.dbo.ExceptionDo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: ExceptionWrapperPlugin
 * @ClassPath com.dasoops.dasserver.plugin.exceptionwrapper.ExceptionWrapperPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/10
 * @Version 1.0.0
 * @Description: 获取异常插件
 */
@Slf4j
@Component
public class GetErrorPlugin extends CqPlugin {



    private final MongoTemplate mongoTemplate;

    public GetErrorPlugin(@SuppressWarnings("all") MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    private PassObj onMessage(CqTemplate cqTemplate, CqMessageEvent event) {

        final List<String> errorPrefixList = List.of("error", "getError");
        String message = event.getMessage();

        for (String prefix : errorPrefixList) {
            if (StrUtil.startWithIgnoreCase(message, prefix)) {
                log.debug("进入获取异常插件逻辑");
                List<String> paramStrList = DqCodeUtil.getParamStr(message, prefix);
                if (paramStrList.isEmpty()) {
                    cqTemplate.sendMsg(event, "我辣么大个id呢?");
                    return PassObj.block();
                }
                int size = paramStrList.size();
                paramStrList.forEach(errorId -> {
                    ExceptionDo po = null;
                    try {
                        Query query = Query.query(Criteria.where("id").is(new ObjectId(errorId)));
                        po = mongoTemplate.findOne(query, ExceptionDo.class);
                    } catch (Exception e) {
                        log.error("get Mongo Exception logs error:", e);
                    }
                    if (po == null) {
                        cqTemplate.sendMsg(event, "这个error不存在捏" + (size <= 1 ? "" : "(" + errorId + ")"));
                    } else {
                        cqTemplate.sendMsg(event, po.getStackMessage());
                    }
                });
                return PassObj.block();
            }
        }
        return PassObj.pass(event);
    }
}
