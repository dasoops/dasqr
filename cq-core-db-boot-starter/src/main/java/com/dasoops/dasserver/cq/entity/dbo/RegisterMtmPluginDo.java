package com.dasoops.dasserver.cq.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Title: RegisterMtmPluginPo
 * @ClassPath com.dasoops.dasserver.cq.entity.po.RegisterMtmPluginPo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: TB_CORE_REGISTER_MTM_PLUGIN
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "TB_CORE_REGISTER_MTM_PLUGIN")
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}