package com.dasoops.dasserver.plugin.reboot.entity.param;

import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: RebootParam
 * @ClassPath com.dasoops.dasserver.plugin.reboot.entity.param.RebootParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/17
 * @Version 1.0.0
 * @Description: 重新启动param
 * @see SimpleParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RebootParam extends SimpleParam {

    /**
     * 模式(all,server,webManager)
     */
    @InjectionParam(order = 0)
    private String mode;

}
