package com.dasoops.dasq.core.cq.entity.po;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @Title: PassList
 * @ClassPath com.dasoops.dasq.cq.entity.PassList
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/07
 * @Version 1.0.0
 * @Description: 过滤白名单
 * @see Serializable
 */
@TableName(value = "TB_CQ_PASS_LIST")
@Data
public class PassObject implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 放行类型(0:群组;1:用户)
     */
    private Integer type;

    /**
     * 放行关键词
     */
    private String passKeyword;

    /**
     * 执行方法ID
     */
    private Long methodInfoId;

    /**
     * 是否启用(0:禁用;1:启用)
     */
    private Integer enable;

    /**
     * 逻辑删除(0:未删除;1:删除)
     */
    @JSONField(serialize = false)
    private String isDelete;

    /**
     * 创建用户
     */
    @JSONField(serialize = false)
    private String createUser;

    /**
     * 创建时间
     */
    @JSONField(serialize = false)
    private Date createTime;

    /**
     * 更新用户
     */
    @JSONField(serialize = false)
    private String updateUser;

    /**
     * 更新时间
     */
    @JSONField(serialize = false)
    private Date updateTime;

    /**
     * 解析methodIds后获取的方法id列表
     */
    @TableField(exist = false)
    private List<Long> methodIdList;

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
        PassObject other = (PassObject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getPassKeyword() == null ? other.getPassKeyword() == null : this.getPassKeyword().equals(other.getPassKeyword()))
                && (this.getMethodIdList() == null ? other.getMethodIdList() == null : this.getMethodIdList().equals(other.getMethodIdList()))
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
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((this.getPassKeyword() == null) ? 0 : this.getPassKeyword().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getMethodIdList() == null) ? 0 : getMethodIdList().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " [" +
                "Hash = " + hashCode() +
                ", id=" + id +
                ", type=" + type +
                ", passKeyword=" + passKeyword +
                ", methodInfoIdList=" + methodIdList +
                ", isDelete=" + isDelete +
                ", createUser=" + createUser +
                ", createTime=" + createTime +
                ", updateUser=" + updateUser +
                ", updateTime=" + updateTime +
                ", serialVersionUID=" + serialVersionUID +
                "]";
    }
}