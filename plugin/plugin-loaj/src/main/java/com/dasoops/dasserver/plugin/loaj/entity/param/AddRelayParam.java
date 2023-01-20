package com.dasoops.dasserver.plugin.loaj.entity.param;

import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: AddRelayParam
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.param.AddRelayParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: 添加回复param
 * @see MessageParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddRelayParam extends SimpleParam {

    /**
     * 关键字
     */
    @InjectionParam(order = 0)
    private String keyword;

    /**
     * 回复
     */
    @InjectionParam(order = 1)
    private String relay;

}
