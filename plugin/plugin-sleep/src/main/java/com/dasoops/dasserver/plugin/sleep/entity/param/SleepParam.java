package com.dasoops.dasserver.plugin.sleep.entity.param;

import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title SleepParam
 * @classPath com.dasoops.dasserver.plugin.sleep.entity.param.SleepParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/10
 * @version 1.0.0
 * @description 睡眠param
 * @see MessageParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SleepParam extends BaseFastBuildParam<BaseDo> {

    /**
     * 睡眠事件
     */
    @InjectionParam(order = 0)
    private String sleepTimeString;

}
