package com.dasoops.cq.entity.po;

import lombok.Data;

import java.util.Date;

/**
 * @Title: BasePo
 * @ClassPath com.dasoops.cq.entity.po.BasePo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: sqlPo基类
 */
@Data
public class BasePo {
    /**
     * 主键id
     */
    private String id;
    /**
     * 逻辑删除(true为删除)
     */
    private boolean isDelete;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建用户(通常为Qid)
     */
    private String createUser;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 更新用户(通常为Qid)
     */
    private String updateUser;
}
