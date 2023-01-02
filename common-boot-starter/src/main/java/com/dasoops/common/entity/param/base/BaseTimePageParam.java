package com.dasoops.common.entity.param.base;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @Title: BasePageParam
 * @ClassPath com.dasoops.common.entity.param.base.BasePageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 基本页面参数
 * @see BaseEasyPageParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseTimePageParam extends BaseEasyTimePageParam {

    @ApiIgnore
    public <T> QueryWrapper<T> buildTimeQueryWrapper(String column) {
        QueryWrapper<T> wrapper = new QueryWrapper<>();
        String beginTimeStr = super.getBeginTime();
        String endTimeStr = super.getEndTime();
        wrapper.ge(beginTimeStr != null && !"".equals(beginTimeStr), column, DateUtil.parse(beginTimeStr));
        wrapper.le(endTimeStr != null && !"".equals(beginTimeStr), column, DateUtil.parse(beginTimeStr));
        return wrapper;
    }

    @ApiIgnore
    public <T> QueryWrapper<T> buildTimeQueryWrapper() {
        return this.buildTimeQueryWrapper("CREATE_TIME");
    }

    @ApiIgnore
    public <T extends BaseDo> IPage<T> buildSelectPage() {
        Page<T> page = new Page<>(super.getCurrent(),super.getSize());
        return page;
    }

}
