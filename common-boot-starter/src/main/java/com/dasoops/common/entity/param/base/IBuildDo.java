package com.dasoops.common.entity.param.base;

import cn.hutool.core.bean.BeanUtil;
import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.util.ReflectUtil;

/**
 * @Title: IBuildDo
 * @ClassPath com.dasoops.common.entity.param.base.IBuildDo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/13
 * @Version 1.0.0
 * @Description: 构建do
 */
public interface IBuildDo<T extends BaseDo> {

    /**
     * 构建do
     *
     * @return {@link T}
     */
    default T buildDo() {
        T t = ReflectUtil.getGenericInstance(getClass(), 0);
        BeanUtil.copyProperties(this, t);
        return t;
    }

}
