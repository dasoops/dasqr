package com.dasoops.common.entity.param.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dasoops.common.entity.dbo.base.BaseDo;

import java.io.Serializable;

/**
 * @Title: BaseParam
 * @ClassPath com.dasoops.common.entity.param.base.BaseParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/26
 * @Version 1.0.0
 * @Description: Param基类
 * @see Serializable
 */
public abstract class BaseParam<T extends BaseDo> implements Serializable, IBuildWrapper<T>, IBuildDo<T> {

    @Override
    public QueryWrapper<T> buildWrapper() {
        QueryWrapper<T> wrapper = IBuildWrapper.super.buildWrapper();
        wrapper.setEntity(IBuildDo.super.buildDo());
        return wrapper;
    }
}