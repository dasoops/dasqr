package com.dasoops.dasserver.plugin.reboot;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: plugin
 * @ClassPath com.dasoops.dasserver.core.plugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class RebootPlugin extends CqPlugin {

    private final RebootEvent rebootEvent;

    public RebootPlugin(RebootEvent rebootEvent) {
        this.rebootEvent = rebootEvent;
    }

    @MessageMapping(prefix = "reboot", type = MessageMappingTypeEnum.ALL)
    public String reboot(CqTemplate cqTemplate, RebootMessageParam param) {
        cqTemplate.sendMsg(param, "gogogo");
        rebootEvent.run();
        return "compile complete,to reboot";
    }

}
