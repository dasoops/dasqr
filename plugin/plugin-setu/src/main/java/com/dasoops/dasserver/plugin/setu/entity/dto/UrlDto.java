package com.dasoops.dasserver.plugin.setu.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: UrlDto
 * @classPath com.dasoops.dasserver.plugin.shell.entity.dto.UrlDto
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/22
 * @version 1.0.0
 * @description urldto
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class UrlDto extends BaseDto {
    /**
     * 原始
     */
    private String original;
    /**
     * 常规
     */
    private String regular;
    /**
     * 540x540
     */
    private String small;
    /**
     * 250x250
     */
    private String thumb;
    /**
     * 48x48
     */
    private String mini;
}
