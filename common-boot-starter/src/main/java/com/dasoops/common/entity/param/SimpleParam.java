package com.dasoops.common.entity.param;

import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.entity.param.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: SimpleParam
 * @ClassPath com.dasoops.common.entity.param.SimpleParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/13
 * @Version 1.0.0
 * @Description: 无对应库无参数简单param
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleParam extends BaseParam<BaseDo> {
}
