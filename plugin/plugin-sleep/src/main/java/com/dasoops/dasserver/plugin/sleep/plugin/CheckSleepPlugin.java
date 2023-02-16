package com.dasoops.dasserver.plugin.sleep.plugin;

import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.plugin.sleep.cache.SleepCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @title IsSleepPlugin
 * @classPath com.dasoops.dasserver.plugin.sleep.IsSleepPlugin
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/10
 * @version 1.0.0
 * @description 静默检查插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class CheckSleepPlugin extends CqPlugin {



    private final SleepCache sleepCache;

    public CheckSleepPlugin(SleepCache sleepCache) {
        this.sleepCache = sleepCache;
    }

    @MessageMapping(matchAll = true, type = MessageMappingTypeEnum.ALL)
    public boolean isSleep(MessageParam<SimpleParam> param, CqTemplate cqTemplate) {
        return !sleepCache.isSleep(param.getIsGroup(), param.getRegisterId());
    }

}
