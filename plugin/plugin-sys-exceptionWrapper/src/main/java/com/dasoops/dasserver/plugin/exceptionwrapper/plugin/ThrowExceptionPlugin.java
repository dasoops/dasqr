package com.dasoops.dasserver.plugin.exceptionwrapper.plugin;

import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: ThrowExceptionPlugin
 * @ClassPath com.dasoops.dasserver.plugin.exceptionwrapper.plugin.ThrowExceptionPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/10
 * @Version 1.0.0
 * @Description: 抛出异常插件
 * @see CqPlugin
 */
@Slf4j
@Component
public class ThrowExceptionPlugin extends CqPlugin {

    @Override
    public CqPlugin getRawPlugin() {
        return this;
    }


    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    public PassObj onMessage(CqTemplate cqTemplate, CqMessageEvent event) {
        final String normalKeyword = "throwException";
        final String crazyKeyword = "throwCrazyException";

        if (normalKeyword.equals(event.getMessage())) {
            throw new LogicException(ExceptionEnum.TEST_EXCEPTION);
        }

        if (crazyKeyword.equals(event.getMessage())) {
            throw new LogicException(ExceptionEnum.CRAZY_TEST_EXCEPTION);
        }
        return PassObj.pass(event);
    }
}
