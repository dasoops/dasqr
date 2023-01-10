package com.dasoops.common.util.entity;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.*;

import java.util.concurrent.TimeUnit;

/**
 * @Title: TimeDto
 * @ClassPath com.dasoops.common.util.entity.TimeDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 时间dto
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeDto extends BaseDto {

    /**
     * 数
     */
    private Long count;

    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

}
