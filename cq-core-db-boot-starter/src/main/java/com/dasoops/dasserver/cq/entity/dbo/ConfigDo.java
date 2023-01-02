package com.dasoops.dasserver.cq.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
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
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="tb_core_config")
@Data
public class ConfigDo extends BaseDo implements Serializable {

    /**
     * 配置项关键词
     */
    private String keyword;

    /**
     * 配置项属性值
     */
    private String value;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否支持web端修改(0:false;1:true)
     */
    private Integer canEdit;
}