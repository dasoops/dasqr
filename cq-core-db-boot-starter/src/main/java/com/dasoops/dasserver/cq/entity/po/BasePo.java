package com.dasoops.dasserver.cq.entity.po;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Title: BasePo
 * @ClassPath com.dasoops.dasserver.cq.entity.po.BasePo
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
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 逻辑删除(true为删除)
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT)
    private boolean isDelete;
    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 创建用户(通常为Qid)
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT)
    private String createUser;
    /**
     * 更新时间
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    /**
     * 更新用户(通常为Qid)
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;
}
