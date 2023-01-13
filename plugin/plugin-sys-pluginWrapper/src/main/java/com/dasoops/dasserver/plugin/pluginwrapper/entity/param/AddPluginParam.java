package com.dasoops.dasserver.plugin.pluginwrapper.entity.param;

import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import com.dasoops.dasserver.cq.entity.event.message.MessageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: AddPluginParam
 * @ClassPath com.dasoops.dasserver.plugin.pluginwrapper.entity.param.AddPluginParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: 添加插件param
 * @see MessageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AddPluginParam extends MessageParam {

    /**
     * 关键字
     */
    @InjectionParam(order = 0)
    private String keyword;

    /**
     * 类路径
     */
    @InjectionParam(order = 1)
    private String classPath;

    /**
     * 描述
     */
    @InjectionParam(order = 2)
    private String description;

    /**
     * 权限等级
     */
    @InjectionParam(order = 3)
    private Integer level;

    /**
     * 是否启用(0:false;1:true)
     */
    @InjectionParam(order = 5)
    private Integer enable;
}
