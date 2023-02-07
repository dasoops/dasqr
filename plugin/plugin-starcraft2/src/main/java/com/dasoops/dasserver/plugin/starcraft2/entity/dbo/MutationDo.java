package com.dasoops.dasserver.plugin.starcraft2.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class MutationDo extends BaseDo {
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
}