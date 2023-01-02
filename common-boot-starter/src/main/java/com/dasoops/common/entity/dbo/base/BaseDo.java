package com.dasoops.common.entity.dbo.base;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @Title: BasePo
 * @ClassPath com.dasoops.dasserver.cq.entity.po.BasePo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: sqlDo基类
 */
@Data
public class BaseDo implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long rowId;
    /**
     * 逻辑删除(true为删除)
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;
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
    private Long createUser;
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
    private Long updateUser;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
