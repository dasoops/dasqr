package com.dasoops.dasserver.cq.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: PluginStatusDto
 * @ClassPath com.dasoops.dasserver.cq.entity.dto.PluginStatusDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/16
 * @Version 1.0.0
 * @Description: 插件状态dto
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PluginStatusDto extends BaseDto {

    /**
     * 行id
     */
    private Long rowId;

    /**
     * 触发关键词
     */
    private String name;

    /**
     * 全类名
     */
    private String classPath;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 权限等级
     */
    private Integer level;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否启用
     */
    private Integer enable;

    /**
     * 状态
     */
    private Integer status;

}