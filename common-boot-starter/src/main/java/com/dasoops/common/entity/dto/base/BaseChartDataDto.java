package com.dasoops.common.entity.dto.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: IndexDataDto
 * @ClassPath cn.qiaoml.bean.dto.history.IndexDataDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/25
 * @Version 1.0.0
 * @Description: 带索引数据dto基类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseChartDataDto extends BaseDto {

    /**
     * 索引
     */
    private List<String> indexList;

}
