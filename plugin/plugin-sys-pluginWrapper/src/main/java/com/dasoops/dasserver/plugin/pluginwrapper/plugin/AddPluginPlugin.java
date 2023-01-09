package com.dasoops.dasserver.plugin.pluginwrapper.plugin;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import com.dasoops.dasserver.cq.entity.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.service.PluginService;
import com.dasoops.dasserver.cq.utils.CqAssert;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.cq.utils.DqCodeUtil;
import com.dasoops.minio.MinioTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

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
    private final MinioTemplate minioTemplate;


    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

//    @MessageMapping(prefix = "addPlugin")
//    public PassObj onGroupMessage(CqTemplate cqTemplate, AddPluginParam param) {
//        CbAssert.checkParamAndSendMessage(cqTemplate.sendM)
//        return PassObj.block();
//    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    public PassObj onMessage(CqTemplate cqTemplate, CqMessageEvent event) {
        final String prefix = "addPlugin";
        String message = event.getMessage();

        if (!StrUtil.startWithIgnoreCase(message, prefix)) {
            return PassObj.pass(event);
        }

        List<String> paramStrList = DqCodeUtil.getParamStr(message, prefix);
        //参数校验
        if (ObjUtil.isEmpty(paramStrList) || paramStrList.size() < 3) {
            cqTemplate.sendMsg(event, "怎么这都不会");
            //发送cbcbcbccb
            cqTemplate.sendMsg(event, CqCodeUtil.image(minioTemplate.buildImagePath("980d4eaa-a536-4f4c-b160-7e8a13f3ce04.jpg")));
            return PassObj.block();
        }

        //addPlugin AddPluginPlugin,com.dasoops.dasserver.plugin.pluginwrapper.plugin.AddPluginPlugin,添加插件插件
        String keyword = paramStrList.get(0);
        String classPath = paramStrList.get(1);
        String description = paramStrList.get(2);

        Integer maxOrder = pluginService.getMaxOrder();

        PluginDo pluginDo = new PluginDo();
        pluginDo.setKeyword(keyword);
        pluginDo.setClassPath(classPath);
        pluginDo.setDescription(description);
        pluginDo.setEnable(1);
        pluginDo.setLevel(9);
        pluginDo.setOrder(maxOrder);
        CqAssert.dbExecuteMustSuccess(pluginService.save(pluginDo));
        return PassObj.block();
    }
}
