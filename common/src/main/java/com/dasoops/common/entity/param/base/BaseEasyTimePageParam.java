package com.dasoops.common.entity.param.base;

import com.dasoops.common.entity.dto.base.BaseDto;
import io.swagger.annotations.ApiModelProperty;
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
public class BaseEasyTimePageParam extends BaseEasyPageParam {

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间", notes = "开始时间", required = true)
    private String beginTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间", notes = "结束时间", required = false)
    private String endTime;
}
