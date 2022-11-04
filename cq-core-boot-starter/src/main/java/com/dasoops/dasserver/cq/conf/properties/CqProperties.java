package com.dasoops.dasserver.cq.conf.properties;

import com.dasoops.dasserver.cq.CqPlugin;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: CqProperties
 * @ClassPath com.dasoops.dasserver.cq.conf.properties.CqProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/02
 * @Version 1.0.0
 * @Description: cq属性
 */
@ConfigurationProperties(prefix = "dasq.cq.core")
@Getter
@Setter
public class CqProperties {

    /**
     * 加载插件集合
     */
    private List<Class<? extends CqPlugin>> pluginList = new ArrayList<>();

    /**
     * 加载数据库插件配置
     */
    private boolean loadLocalPluginList = false;

    /**
     * 控制台打印异常堆栈信息
     */
    private boolean consolePrintStack = false;

    /**
     * 使用jdk原生错误打印
     */
    private boolean nativePrintStack = false;

    /**
     * 是否为demo环境
     */
    private boolean isDemo = true;

    /**
     * 开发群id
     */
    private Long devGroupId;

    /**
     * 主开发者id
     */
    private Long devUserId;

}
