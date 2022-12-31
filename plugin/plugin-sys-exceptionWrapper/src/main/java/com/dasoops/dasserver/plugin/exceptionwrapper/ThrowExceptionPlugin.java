package com.dasoops.dasserver.plugin.exceptionwrapper;

import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.WebLogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.bot.PassObj;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: ThrowExceptionPlugin
 * @ClassPath com.dasoops.dasserver.plugin.exceptionwrapper.ThrowExceptionPlugin
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
            throw new WebLogicException(ExceptionEnum.TEST_EXCEPTION);
        }

        if (crazyKeyword.equals(event.getMessage())) {
            throw new WebLogicException(ExceptionEnum.CRAZY_TEST_EXCEPTION);
        }
        return PassObj.pass(event);
    }
}
