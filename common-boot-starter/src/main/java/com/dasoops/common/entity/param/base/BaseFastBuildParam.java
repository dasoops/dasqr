package com.dasoops.common.entity.param.base;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dasoops.common.entity.dbo.base.BaseDo;

import java.io.Serializable;

/**
 * @Title: BaseBuildParam
 * @ClassPath com.dasoops.common.entity.param.base.BaseBuildParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: 快速构建param
 * @see Serializable
 * @see IBuildWrapper
 * @see IBuildDo
 */
public abstract class BaseFastBuildParam<T extends BaseDo> extends BaseParam implements IBuildWrapper<T>, IBuildDo<T> {

    @Override
    public QueryWrapper<T> buildQueryWrapper() {
        QueryWrapper<T> wrapper = IBuildWrapper.super.buildQueryWrapper();
        wrapper.setEntity(IBuildDo.super.buildDo());
        return wrapper;
    }
}