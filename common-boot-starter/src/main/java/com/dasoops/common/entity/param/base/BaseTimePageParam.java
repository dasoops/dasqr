package com.dasoops.common.entity.param.base;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BasePageParam
 * @ClassPath com.dasoops.common.entity.param.base.BasePageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 基本页面参数
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseTimePageParam<T> extends BasePageParam implements IBuildWrapper<T> {

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

    public QueryWrapper<T> buildWrapper(String column) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        String beginTimeStr = this.getBeginTime();
        String endTimeStr = this.getEndTime();
        wrapper.ge(beginTimeStr != null && !"".equals(beginTimeStr), column, DateUtil.parse(beginTimeStr));
        wrapper.le(endTimeStr != null && !"".equals(beginTimeStr), column, DateUtil.parse(beginTimeStr));
        return wrapper;
    }

    @Override
    public QueryWrapper<T> buildWrapper() {
        return this.buildWrapper("CREATE_TIME");
    }


}
