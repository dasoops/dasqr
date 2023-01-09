package com.dasoops.dasserver.plugin.pluginwrapper.plugin;

import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.plugin.pluginwrapper.entity.enums.PluginEnableEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
public class GetPluginPlugin extends CqPlugin {
    private final PluginService pluginService;
    private final ApplicationContext context;

    public GetPluginPlugin(PluginService pluginService, ApplicationContext context) {
        this.pluginService = pluginService;
        this.context = context;
    }

    @MessageMapping(prefix = {"getPlugin", "getPluginList", "getAllPlugin", "allPlugin"}, type = MessageMappingTypeEnum.ALL)
    public String getAllPlugin() {
        //获取有记录的所有插件
        List<PluginDo> pluginDoList = pluginService.list();
        //加载的插件
        Map<String, CqPlugin> loadPluginMap = context.getBeansOfType(CqPlugin.class);

        StringBuilder sb = new StringBuilder();
        for (PluginDo pluginDo : pluginDoList) {
            //0为未启用, 1启用未加载, 2加载, 3加载但无记录(不启用)
            Integer enable = pluginDo.getEnable();
            int status;
            //未启用
            if (enable.equals(PluginEnableEnum.FALSE.getDbValue())) {
                status = 0;
            } else {
                boolean isLoad = loadPluginMap.values().stream().anyMatch(cqPlugin -> cqPlugin.getClass().getName().equals(pluginDo.getClassPath()));
                status = isLoad ? 2 : 1;
            }
            sb.append(buildPluginStatusString(pluginDo, status));
        }

        //说明有加载了但无数据库记录的插件
        if (loadPluginMap.size() > pluginDoList.size()) {
            List<String> pluginClassNameList = pluginDoList.stream().map(PluginDo::getClassPath).toList();
            List<CqPlugin> noRecordButLoadPluginList = loadPluginMap.values().stream().filter(cqPlugin -> !pluginClassNameList.contains(cqPlugin.getClass().getName())).toList();
            noRecordButLoadPluginList.forEach(cqPlugin -> sb.append(buildUnkownPlugin(cqPlugin)));
        }

        return sb.toString();
    }

    public String buildPluginStatusString(PluginDo pluginDo, Integer status) {
        //获取插件名称
        String classPath = pluginDo.getClassPath();
        String className = classPath.substring(classPath.lastIndexOf(".") + 1);

        //启用状态
        String statusStr = switch (status) {
            case 0 -> "-";
            case 1 -> "x";
            case 2 -> "√";
            case 3 -> "?";
            default -> "";
        };

        String id = String.valueOf(pluginDo.getRowId());
        String description = pluginDo.getDescription();

        //拼接
        String pluginStringFormat = "{}. {}({})[{}]\r\n";
        return StrUtil.format(pluginStringFormat, id, className, description, statusStr);
    }

    public String buildUnkownPlugin(CqPlugin cqPlugin) {
        //获取插件名称
        String className = cqPlugin.getClass().getSimpleName();

        //拼接
        String pluginStringFormat = "?. {}(未知插件)[?]\r\n";
        return StrUtil.format(pluginStringFormat, className);
    }

}
