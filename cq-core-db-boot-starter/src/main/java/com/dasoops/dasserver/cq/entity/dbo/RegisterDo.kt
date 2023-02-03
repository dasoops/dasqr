package com.dasoops.dasserver.cq.entity.dbo

import com.baomidou.mybatisplus.annotation.TableName
import com.dasoops.common.entity.dbo.base.BaseDo

/**
 * @Title: Register
 * @ClassPath com.dasoops.dasserver.cq.entity.po.Register
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 注册表, 储存用户注册信息, 初始权限, 群组注册信息
 * @see BaseDo
 */
@TableName(value = "tb_core_register")
data class RegisterDo(
    /**
     * 用户/群组id
     */
    var registerId: Long? = null,

    /**
     * 类型(0:user;1:group)
     */
    var type: Int? = null,

    /**
     * 默认权限等级(组为-1|0:sys;1:dev;2:user;8:zxy;9:none)
     */
    var level: Int? = null
) : BaseDo()