package com.dasoops.dasserver.plugin.reboot;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import org.springframework.stereotype.Component;

/**
 * @Title: StartNoticeWsWrapper
 * @ClassPath com.dasoops.dasserver.plugin.reboot.StartNoticeWsWrapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 启动提醒ws增强
 * @see WsWrapper
 */
@Component
public class StartNoticeWsWrapper implements WsWrapper {

    private final CqProperties cqProperties;

    public StartNoticeWsWrapper(CqProperties cqProperties) {
        this.cqProperties = cqProperties;
    }

    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), "DasServer start", false);
    }

    @Override
    public Integer getOrder() {
        return 2147483643;
    }

    @Override
    public Boolean getInitIsCompleted() {
        return true;
    }
}
