package com.dasoops.dasserver.plugin.reboot.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title RebootParam
 * @classPath com.dasoops.dasserver.plugin.reboot.entity.param.RebootParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/17
 * @version 1.0.0
 * @description 重新启动param
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RebootParam extends BaseParam {

    /**
     * 模式(all,server,webManager)
     */
    @InjectionParam(order = 0)
    private String mode;

}
