package com.dasoops.dasserver.plugin.setu.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: SetuDto
 * @ClassPath com.dasoops.dasserver.plugin.setu.entity.dto.SetuDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/22
 * @Version 1.0.0
 * @Description: setudto
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class SetuInfoDto extends BaseDto {
    /**
     * pid
     */
    private long pid;
    /**
     * p
     */
    private int p;
    /**
     * uid
     */
    private long uid;
    /**
     * 标题
     */
    private String title;
    /**
     * 作者
     */
    private String author;
    /**
     * r18
     */
    private Boolean r18;
    /**
     * 宽度
     */
    private Integer width;
    /**
     * 高度
     */
    private Integer height;
    /**
     * 标签
     */
    private List<String> tags;
    /**
     * 文件类型
     */
    private String ext;
    /**
     * 上传日期
     */
    private Long uploadDate;
    /**
     * url
     */
    private UrlDto urls;

}
