package com.dasoops.dasserver.plugin.starcraft2.entity.dbo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: MutationDo
 * @ClassPath com.dasoops.dasserver.plugin.starcraft2.entity.dbo.MutationDo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: sc2 突变
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "tb_plugin_star_craft_2_mutation")
@Data
public class MutationDo extends BaseDo implements Serializable {
    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
    private Long rowId;

    /**
     * 突变名
     */
    private String name;

    /**
     * 因子
     */
    private String factor;

    /**
     * 地图
     */
    private String map;

    /**
     * 因子分数
     */
    private Integer score;

    /**
     * 对应等级(+1)
     */
    private Integer level;

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