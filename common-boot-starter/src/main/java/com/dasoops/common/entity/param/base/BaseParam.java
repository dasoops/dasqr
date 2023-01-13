package com.dasoops.common.entity.param.base;

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
public class BaseParam<T extends BaseDo> implements Serializable, IBuildWrapper<T> {
}
