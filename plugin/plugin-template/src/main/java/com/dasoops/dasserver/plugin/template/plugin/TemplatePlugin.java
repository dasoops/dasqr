package com.dasoops.dasserver.plugin.setu.plugin;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TemplatePlugin extends CqPlugin {

    @MessageMapping(prefix = "template", type = MessageMappingTypeEnum.ALL)
    public boolean template() {
        //放行
        return true;
    }

}
