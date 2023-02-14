package com.dasoops.dasserver.plugin.setu.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @title: SetuResultDto
 * @classPath com.dasoops.dasserver.plugin.shell.entity.dto.SetuResultDto
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/22
 * @version 1.0.0
 * @description setu结果dto
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class SetuResultDto extends BaseDto {
    /**
     * 错误
     */
    private String error;
    /**
     * 数据
     */
    private List<SetuInfoDto> data;
}
