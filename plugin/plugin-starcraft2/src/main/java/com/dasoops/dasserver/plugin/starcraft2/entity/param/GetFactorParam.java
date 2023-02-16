package com.dasoops.dasserver.plugin.starcraft2.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title GetFactorParam
 * @classPath com.dasoops.dasserver.plugin.starcraft2.entity.param.GetFactorParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/20
 * @version 1.0.0
 * @description 获取因子param
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GetFactorParam extends BaseParam {

    /**
     * 名称
     */
    @InjectionParam(order = 0)
    private String name;

}
