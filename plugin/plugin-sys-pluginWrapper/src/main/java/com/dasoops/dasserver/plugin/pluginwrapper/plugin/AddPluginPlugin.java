package com.dasoops.dasserver.plugin.pluginwrapper.plugin;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.result.PluginResult;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.utils.CqMessageAssert;
import com.dasoops.dasserver.plugin.pluginwrapper.entity.enums.PluginEnableEnum;
import com.dasoops.dasserver.plugin.pluginwrapper.entity.param.AddPluginParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: AddPluginPlugin
 * @ClassPath com.dasoops.dasserver.plugin.pluginwrapper.plugin.AddPluginPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/11
 * @Version 1.0.0
 * @Description: 添加插件插件
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class AddPluginPlugin extends CqPlugin {

    private final PluginService pluginService;

    @MessageMapping(prefix = "addPlugin", type = MessageMappingTypeEnum.ALL)
    public PluginResult addPlugin(CqTemplate cqTemplate, AddPluginParam param) {
        CqMessageAssert.allMustNotNull(param, param.getKeyword(), param.getClassPath(), param.getDescription(), param.getLevel());

        Integer maxOrder = pluginService.getMaxOrder();

        PluginDo pluginDo = new PluginDo();
        pluginDo.setKeyword(param.getKeyword());
        pluginDo.setClassPath(param.getClassPath());
        pluginDo.setDescription(param.getDescription());
        pluginDo.setEnable(PluginEnableEnum.TRUE.getDbValue());
        pluginDo.setLevel(param.getLevel());
        pluginDo.setOrder(maxOrder + 1);
        pluginService.save(pluginDo);

        return PluginResult.of("已阅");
    }
}
