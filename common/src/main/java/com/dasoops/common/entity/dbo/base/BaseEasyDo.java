package com.dasoops.common.entity.dbo.base;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: BaseDo
 * @ClassPath com.dasoops.common.entity.dbo.base.BaseDo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: Do基类
 * @see Serializable
 */
@Data
public class BaseEasyDo implements Serializable {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 逻辑删除;0:false,1:true
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 更新用户
     */
    private String updateUser;

}
