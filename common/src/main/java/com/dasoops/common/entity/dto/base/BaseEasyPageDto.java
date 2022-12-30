package com.dasoops.common.entity.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: BasePageDto
 * @ClassPath cn.qiaoml.bean.dto.BasePageDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/30
 * @Version 1.0.0
 * @Description: 分页数据dto基类
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEasyPageDto<T> extends BaseDto {

    private List<T> data;

    /**
     * 每页显示数量
     */
    private Integer size = 10;

    /**
     * 当前页码
     */
    private Integer current = 1;

    /**
     * 总数
     */
    private Integer total;

}
