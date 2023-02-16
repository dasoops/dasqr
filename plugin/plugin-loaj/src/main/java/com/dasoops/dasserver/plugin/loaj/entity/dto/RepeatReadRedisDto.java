package com.dasoops.dasserver.plugin.loaj.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title RepeatReadDto
 * @classPath com.dasoops.dasserver.plugin.loaj.entity.dto.RepeatReadDto
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/19
 * @version 1.0.0
 * @description 复读RedisDto
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
