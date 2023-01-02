package com.dasoops.dasserver.plugin.pluginwrapper.plugin;

import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.cq.bot.PassObj;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.service.PluginService;
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

    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    public PassObj onMessage(CqTemplate cqTemplate, CqMessageEvent event) {
        String message = event.getMessage();
        final String keyword = "getPlugin";
        if (StrUtil.equalsIgnoreCase(message, keyword)) {
            //获取所有插件
            List<PluginDo> pluginList = pluginService.list();
            //加载的插件
            Map<String, CqPlugin> loadPluginMap = context.getBeansOfType(CqPlugin.class);

            StringBuilder sb = new StringBuilder();
            String format = "{}. {}({})[{}]\r\n";

            pluginList.forEach(pluginPo -> {
                //0为未启用, 1启用未加载, 2加载
                Integer status = pluginPo.getEnable();
                if (status == 1) {
                    //是否加载
                    boolean isLoad = loadPluginMap.values().stream().anyMatch(plugin -> {
                        try {
                            return Class.forName(pluginPo.getClassPath()).isInstance(plugin);
                        } catch (ClassNotFoundException e) {
                            return false;
                        }
                    });
                    if (isLoad) {
                        status = 2;
                    }
                }

                //获取插件名称
                String classPath = pluginPo.getClassPath();
                String className = classPath.substring(classPath.lastIndexOf(".") + 1);

                //启用状态
                String statusStr;
                switch (status) {
                    case 1:
                        statusStr = "-";
                        break;
                    case 2:
                        statusStr = "√";
                        break;
                    default:
                        statusStr = "×";
                        break;
                }

                String id = String.valueOf(pluginPo.getRowId());
                String description = pluginPo.getDescription();

                //拼接
                sb.append(StrUtil.format(format, id, className, description, statusStr));
            });

            cqTemplate.sendMsg(event, sb.toString());
            return PassObj.block();
        }
        return PassObj.pass(event);
    }

}
