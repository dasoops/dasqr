package com.dasoops.dasserver.cq.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Title: Config
 * @ClassPath com.dasoops.dasserver.cq.entity.po.Config
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 配置表, 储存配置信息, 如:version,mutation等
 * @see BasePo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="TB_CORE_CONFIG")
@Data
public class ConfigPo extends BasePo implements Serializable {

    /**
     * 配置项关键词
     */
    private String keyword;

    /**
     * 配置项属性值
     */
    private String value;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}