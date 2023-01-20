package com.dasoops.dasserver.plugin.starcraft2.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: FactorDo
 * @ClassPath com.dasoops.dasserver.plugin.starcraft2.entity.dbo.FactorDo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: sc2 因子
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "tb_plugin_star_craft_2_factor")
@Data
public class FactorDo extends BaseDo implements Serializable {
    /**
     * 主键id
     */
    @TableId
    private Long rowId;

    /**
     * 名称
     */
    private String name;

    /**
     * 分数
     */
    private String score;

    /**
     * 描述
     */
    private String description;

    /**
     * 对应图片名称
     */
    private String imageFileName;

    /**
     * 逻辑删除(0:未删除;1:删除)
     */
    private Integer isDelete;

    /**
     * 创建用户
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新用户
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}