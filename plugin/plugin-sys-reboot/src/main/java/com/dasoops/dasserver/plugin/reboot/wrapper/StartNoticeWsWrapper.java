package com.dasoops.dasserver.plugin.reboot.wrapper;

import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.wrapper.WsWrapper;
import com.dasoops.dasserver.plugin.reboot.entity.enums.QuietBootEnum;
import com.dasoops.dasserver.plugin.reboot.entity.enums.RebootConfigHashKeyEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @title StartNoticeWsWrapper
 * @classPath com.dasoops.dasserver.plugin.reboot.wrapper.StartNoticeWsWrapper
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/10
 * @version 1.0.0
 * @description 启动提醒ws增强
 * @see WsWrapper
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class StartNoticeWsWrapper implements WsWrapper {

    private final CqProperties cqProperties;
    private final ConfigCache configCache;

    @Override
    public void afterConnectionEstablishedWrapper(CqTemplate cqTemplate) {
        QuietBootEnum quietBootEnum = configCache.getEnumConfig(RebootConfigHashKeyEnum.QUIET_BOOT, QuietBootEnum.class);
        if (quietBootEnum.equals(QuietBootEnum.FALSE)) {
            cqTemplate.sendGroupMsg(cqProperties.getDevGroupId(), "DasServer start", false);
        }
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
