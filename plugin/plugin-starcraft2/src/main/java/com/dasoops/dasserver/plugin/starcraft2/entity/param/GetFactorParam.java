package com.dasoops.dasserver.plugin.starcraft2.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
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
