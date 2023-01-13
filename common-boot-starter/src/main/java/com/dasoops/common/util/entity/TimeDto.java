package com.dasoops.common.util.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

/**
 * @Title: TimeDto
 * @ClassPath com.dasoops.common.util.entity.TimeDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 时间dto
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeDto {

    /**
     * 数
     */
    private Long count;

    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

}
