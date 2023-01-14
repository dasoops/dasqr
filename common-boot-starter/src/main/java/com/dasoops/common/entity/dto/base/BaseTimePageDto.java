package com.dasoops.common.entity.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BaseTimePageDto
 * @ClassPath cn.qiaoml.bean.dto.user.BaseTimePageDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/05
 * @Version 1.0.0
 * @Description: 时间分页dto基类
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseTimePageDto extends BaseDto {

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 每页显示数量
     */
    private Integer size = 10;

    /**
     * 当前页码
     */
    private Integer current = 1;
}
