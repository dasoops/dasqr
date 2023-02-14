package com.dasoops.dasserver.cq.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @title RegisterMtmPluginPo
 * @classPath com.dasoops.dasserver.cq.entity.po.RegisterMtmPluginPo
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/01
 * @version 1.0.0
 * @description tb_core_register_mtm_plugin
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "tb_core_register_mtm_plugin")
@Data
public class RegisterMtmPluginDo extends BaseDo implements Serializable {

    /**
     * 插件主键id
     */
    private Long pluginId;

    /**
     * 注册用户主键id
     */
    private Long registerRowId;

    /**
     * 是否放行(0:否,拦截;1:是,放行)
     */
    private Integer isPass;
}