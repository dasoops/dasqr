package com.dasoops.dasserver.plugin.exec.plugin;

import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.event.message.MappingMessage;
import com.dasoops.dasserver.plugin.exec.ExecTemplate;
import com.dasoops.dasserver.plugin.exec.entity.param.ExecParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: TemplatePlugin
 * @ClassPath com.dasoops.dasserver.template.plugin.TemplatePlugin.TemplatePlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/18
 * @Version 1.0.0
 * @Description: 执行插件
 * @see CqPlugin
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ExecPlugin extends CqPlugin {

    private final ExecTemplate execTemplate;

    @MessageMapping(prefix = "exec", at = true, type = MessageMappingTypeEnum.ALL)
    @SuppressWarnings("all")
    public String exec(MappingMessage<ExecParam> message, CqTemplate cqTemplate) {
        cqTemplate.sendMsg(message, "gogogo");
        try {
            execTemplate.exec(message.getParam().getExecFileKeyword());
        } catch (LogicException e) {
            return e.getExceptionEnum().getMsg();
        }
        return "exec completed";
    }

}
