package com.dasoops.common.entity.vo.base;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(value = "索引", notes = "索引", example = "[\"1月1日\",\"1月2日\"]", required = true)
    private List<String> indexList;

}
