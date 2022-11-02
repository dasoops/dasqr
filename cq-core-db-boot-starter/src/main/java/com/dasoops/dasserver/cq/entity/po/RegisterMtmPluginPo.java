package com.dasoops.dasserver.cq.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: RegisterMtmPluginPo
 * @ClassPath com.dasoops.dasserver.cq.entity.po.RegisterMtmPluginPo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: TB_CORE_REGISTER_MTM_PLUGIN
 * @see BasePo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="TB_CORE_REGISTER_MTM_PLUGIN")
@Data
public class RegisterMtmPluginPo extends BasePo implements Serializable {

    /**
     * 插件主键id
     */
    private Integer pluginId;

    /**
     * 注册用户主键id
     */
    private Integer registerId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}