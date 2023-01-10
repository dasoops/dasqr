package com.dasoops.dasserver.plugin.sleep;

import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import com.dasoops.dasserver.cq.entity.event.message.MessageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: SleepParam
 * @ClassPath com.dasoops.dasserver.plugin.sleep.SleepParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 睡眠param
 * @see MessageParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SleepParam extends MessageParam {

    /**
     * 睡眠事件
     */
    @InjectionParam(order = 0)
    private String sleepTimeString;

}
