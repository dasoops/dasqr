package com.dasoops.dasserver.plugin.sleep.plugin;

import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.event.message.MappingMessage;
import com.dasoops.dasserver.plugin.sleep.cache.SleepCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: IsSleepPlugin
 * @ClassPath com.dasoops.dasserver.plugin.sleep.IsSleepPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 静默检查插件
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
    public boolean isSleep(MappingMessage<SimpleParam> param, CqTemplate cqTemplate) {
        return !sleepCache.isSleep(param.getIsGroup(), param.getRegisterId());
    }

}
