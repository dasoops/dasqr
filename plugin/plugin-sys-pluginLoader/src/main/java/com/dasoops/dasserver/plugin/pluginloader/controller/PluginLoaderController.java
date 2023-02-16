package com.dasoops.dasserver.plugin.pluginloader.controller;

import com.dasoops.common.entity.result.SimpleResult;
import com.dasoops.dasserver.cq.CqPluginGlobal;
import com.dasoops.dasserver.plugin.pluginloader.core.ModuleApplication;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

/**
 * @title ClassLoaderController
 * @classPath com.dasoops.dasserver.plugin.pluginloader.controller.ClassLoaderController
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/06
 * @version 1.0.0
 * @description 类装入器控制器
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class PluginLoaderController {

    private final SqlSessionFactory sqlSessionFactory;
    private final ApplicationContext applicationContext;

    @GetMapping(value = "/loadJar")
    public SimpleResult loadJar() throws Exception {

//        String jarPath = "D:\\workSpace\\java\\_my\\DasServer\\plugin\\plugin-image\\target\\plugin-image-1.0.0.jar";
//        File jar = new File(jarPath);
//        URI uri = jar.toURI();
//        URL url = uri.toURL();
        URL url = new URL("file:D:\\workSpace\\java\\_my\\DasServer\\plugin\\plugin-image\\target\\plugin-image-1.0.0.jar");
        ModuleApplication moduleApplication = (ModuleApplication) applicationContext.getBean("moduleApplication");
        moduleApplication.reloadJar(url, applicationContext, sqlSessionFactory);

        CqPluginGlobal.refresh();
        return SimpleResult.success();
    }


}
