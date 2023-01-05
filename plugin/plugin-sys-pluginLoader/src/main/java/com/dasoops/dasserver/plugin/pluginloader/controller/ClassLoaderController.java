package com.dasoops.dasserver.plugin.pluginloader.controller;


import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.bot.CqTemplate;
import com.dasoops.dasserver.plugin.pluginloader.core.ModuleApplication;
import com.dasoops.dasserver.plugin.pluginloader.v1.util.SpringContextUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class ClassLoaderController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @GetMapping(value = "/loadJar")
    public List<?> loadJar() throws Exception {

        String jarPath = "D:\\workSpace\\java\\_my\\DasServer\\plugin\\plugin-image\\target\\plugin-image-0.0.1.jar";
        File jar = new File(jarPath);
        URI uri = jar.toURI();
        URL url = uri.toURL();
        ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
        ModuleApplication moduleApplication = (ModuleApplication) applicationContext.getBean("moduleApplication");
        moduleApplication.reloadJar(url, applicationContext, sqlSessionFactory);

        CqTemplate cqTemplate = CqGlobal.findFirst().get();
        Map<String, CqPlugin> beansOfType = SpringContextUtil.getApplicationContext().getBeansOfType(CqPlugin.class);
        List<Class<? extends CqPlugin>> pluginList = new ArrayList<>();
        beansOfType.values().stream().map(CqPlugin::getClass).forEach(pluginList::add);
        cqTemplate.setPluginList(pluginList);
        CqGlobal.robots.put(cqTemplate.getSelfId(), cqTemplate);
        return SpringContextUtil.getAllBean();
    }


}
