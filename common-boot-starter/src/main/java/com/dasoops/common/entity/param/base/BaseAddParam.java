package com.dasoops.common.entity.param.base;

import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BaseAddParam
 * @ClassPath com.dasoops.common.entity.param.base.BaseAddParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/13
 * @Version 1.0.0
 * @Description: 新增param基类
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseAddParam<T extends BaseDo> extends BaseParam<T>{
}
