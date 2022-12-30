package com.dasoops.common.entity.vo.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: BaseChartDataDto
 * @ClassPath cn.qiaoml.bean.vo.BaseChartDataDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/28
 * @Version 1.0.0
 * @Description: 图表数据vo基类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseChartDataVo extends BaseVo{

    /**
     * 索引
     */
    private List<String> indexList;

}
