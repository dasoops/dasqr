package com.dasoops.common.entity.param.base;

import cn.hutool.core.bean.BeanUtil;
import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.LogicException;

import java.lang.reflect.ParameterizedType;

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
    default T buildDo(){
        {
            ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
            @SuppressWarnings("all")
            Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
            T t;
            try {
                t = type.getConstructor().newInstance();
            } catch (Exception e) {
                throw new LogicException(ExceptionEnum.NO_NULL_PARAMETER_CONSTRUCTOR);

            }
            BeanUtil.copyProperties(this, t);
            return t;
        }
    }

}
