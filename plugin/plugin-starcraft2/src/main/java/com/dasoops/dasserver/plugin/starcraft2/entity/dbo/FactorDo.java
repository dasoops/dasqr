package com.dasoops.dasserver.plugin.starcraft2.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class FactorDo extends BaseDo{

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

}