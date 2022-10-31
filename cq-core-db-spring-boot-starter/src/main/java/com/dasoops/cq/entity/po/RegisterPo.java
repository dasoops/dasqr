package com.dasoops.cq.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: Register
 * @ClassPath com.dasoops.cq.entity.po.Register
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 注册表, 储存用户注册信息, 初始权限, 群组注册信息
 * @see BasePo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="TB_CORE_REGISTER")
@Data
public class RegisterPo extends BasePo implements Serializable {

    /**
     * 用户/群组id
     */
    private Integer registerId;

    /**
     * 类型(0:user;1:group)
     */
    private Integer type;

    /**
     * 默认权限等级(组为-1|0:sys;1:dev;2:user;8:zxy;9:none)
     */
    private Integer level;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}