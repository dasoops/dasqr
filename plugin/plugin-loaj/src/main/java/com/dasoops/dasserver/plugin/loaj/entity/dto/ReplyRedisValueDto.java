package com.dasoops.dasserver.plugin.loaj.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ReplyRedisDataDto
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.dto.ReplyRedisDataDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: 回复redis缓存数据
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ReplyRedisValueDto extends BaseDto {

    /**
     * 关键字
     */
    private String keyword;
    /**
     * 回复
     */
    private String reply;

    /**
     * 匹配规则
     */
    private Integer matchType;

    /**
     * 忽略大小写
     */
    private Boolean ignoreCase;

    /**
     * 忽略全半角
     */
    private Boolean ignoreDbc;

}
