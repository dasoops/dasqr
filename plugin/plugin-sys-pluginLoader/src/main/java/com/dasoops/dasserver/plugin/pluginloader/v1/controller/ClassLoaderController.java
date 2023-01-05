package com.dasoops.dasserver.plugin.pluginloader.v1.controller;


import com.dasoops.dasserver.plugin.pluginloader.v1.classloader.ClassloaderResponsity;
import com.dasoops.dasserver.plugin.pluginloader.v1.classloader.ModuleClassLoader;
import com.dasoops.dasserver.plugin.pluginloader.v1.util.SpringContextUtil;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;

//@RestController
//@RequestMapping(value = "/loader")
public class ClassLoaderController {


    @GetMapping(value = "/beans")
    public List<Map<String, Object>> beans() {
        return SpringContextUtil.getAllBean();
    }

    @GetMapping(value = "/deleteModule")
    public List<Map<String, Object>> deleteModule(String moduleName) {
        if (ClassloaderResponsity.getInstance().containsClassLoader(moduleName)) {
            ClassloaderResponsity.getInstance().removeClassLoader(moduleName);
        }
        return beans();
    }

//    @GetMapping(value = "/loadJar")
    public List<?> loadJar(String jarPath) {

        jarPath = "D:\\workSpace\\java\\_my\\DasServer\\plugin\\plugin-image\\target\\plugin-image-0.0.1.jar";

        File jar = new File(jarPath);
        URI uri = jar.toURI();
        String moduleName = jarPath.substring(jarPath.lastIndexOf("/") + 1, jarPath.lastIndexOf("."));
        try {

            if (ClassloaderResponsity.getInstance().containsClassLoader(moduleName)) {
                ClassloaderResponsity.getInstance().removeClassLoader(moduleName);
            }

            ModuleClassLoader classLoader = new ModuleClassLoader(new URL[]{uri.toURL()}, Thread.currentThread().getContextClassLoader());
            SpringContextUtil.getBeanFactory().setBeanClassLoader(classLoader);
            Thread.currentThread().setContextClassLoader(classLoader);
            classLoader.initBean();
            ClassloaderResponsity.getInstance().addClassLoader(moduleName, classLoader);

            DefaultListableBeanFactory autowireCapableBeanFactory = (DefaultListableBeanFactory) SpringContextUtil.getApplicationContext().getAutowireCapableBeanFactory();
            autowireCapableBeanFactory.setBeanClassLoader(classLoader);
//            autowireCapableBeanFactory.set
            MapperScannerConfigurer mapperScannerConfigurer = (MapperScannerConfigurer)SpringContextUtil.getBean("org.mybatis.spring.mapper.MapperScannerConfigurer");
            mapperScannerConfigurer.postProcessBeanDefinitionRegistry(autowireCapableBeanFactory);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return SpringContextUtil.getAllBean();
    }

    @GetMapping(value = "/invoke")
    public Object invokeBean(String beanName) {
        Method method = ReflectionUtils.findMethod(SpringContextUtil.getBean(beanName).getClass(), "users");
        Object result = ReflectionUtils.invokeMethod(method, SpringContextUtil.getBean(beanName));
        return result;
    }

}
