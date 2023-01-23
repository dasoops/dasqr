package com.dasoops.dasserver.plugin.setu.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: SetuResultDto
 * @ClassPath com.dasoops.dasserver.plugin.shell.entity.dto.SetuResultDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/22
 * @Version 1.0.0
 * @Description: setu结果dto
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
