package com.dasoops.dasserver.plugin.loaj.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: RepeatReadDto
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.dto.RepeatReadDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/19
 * @Version 1.0.0
 * @Description: 复读RedisDto
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RepeatReadRedisDto extends BaseDto {

    /**
     * 消息
     */
    private String message;

    /**
     * 计数
     */
    private Integer count;

}
