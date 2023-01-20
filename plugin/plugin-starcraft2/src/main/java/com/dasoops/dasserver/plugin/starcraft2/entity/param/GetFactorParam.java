package com.dasoops.dasserver.plugin.starcraft2.entity.param;

import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetFactorParam
 * @ClassPath com.dasoops.dasserver.plugin.starcraft2.entity.param.GetFactorParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 获取因子param
 * @see SimpleParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GetFactorParam extends SimpleParam {

    /**
     * 名称
     */
    @InjectionParam(order = 0)
    private String name;

}
