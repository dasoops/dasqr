package com.dasoops.dasserver.cq.event;

import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @title DestroyEvent
 * @classPath com.dasoops.dasq.core.common.event.DestroyEvent
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/12
 * @version 1.0.0
 * @description 破坏事件
 * @see DisposableBean
 */
@Component
public class DestroyEvent implements DisposableBean {

    private final CqProperties cqProperties;

    public DestroyEvent(CqProperties cqProperties) {
        this.cqProperties = cqProperties;
    }

    @Override
    public void destroy() {
        CqGlobal.getAll().forEach(cqTemplate -> {
            cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), "DasServer destroy", false);
        });
    }
}