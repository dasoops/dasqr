package com.dasoops.dasq.core.cq.entity.po;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @Title: MethodInfo
 * @ClassPath com.dasoops.dasq.core.cq.entity.po.MethodInfo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: 方法信息
 * @see Serializable
 */
@TableName(value = "TB_CQ_METHOD_INFO")
@Data
public class MethodInfo implements Serializable {
    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 方法类型id
     */
    private Long typeId;

    /**
     * 方法参数(可为集合,以','分割,影响先后顺序)
     */
    private String parameters;

    /**
     * 是否启用(0:fasle;1:true)
     */
    private Integer enable;

    /**
     * 描述
     */
    private String description;

    /**
     * 逻辑删除(0:未删除;1:删除)
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT)
    private String isDelete;

    /**
     * 创建用户
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新用户
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUser;

    /**
     * 更新时间
     */
    @JSONField(serialize = false)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MethodInfo other = (MethodInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
                && (this.getParameters() == null ? other.getParameters() == null : this.getParameters().equals(other.getParameters()))
                && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
                && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
                && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
                && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getParameters() == null) ? 0 : getParameters().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        String sb = getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", typeId=" + typeId +
                ", parameters=" + parameters +
                ", enable=" + enable +
                ", description=" + description +
                ", isDelete=" + isDelete +
                ", createUser=" + createUser +
                ", createTime=" + createTime +
                ", updateUser=" + updateUser +
                ", updateTime=" + updateTime +
                ", serialVersionUID=" + serialVersionUID +
                "]";
        return sb;
    }
}