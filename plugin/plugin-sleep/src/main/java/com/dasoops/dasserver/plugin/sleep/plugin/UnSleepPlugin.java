package com.dasoops.dasserver.plugin.sleep.plugin;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.plugin.sleep.cache.SleepCache;
import com.dasoops.dasserver.plugin.sleep.entity.param.SleepParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: SleepPlugin
 * @ClassPath com.dasoops.dasserver.plugin.sleep.plugin.SleepPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 解除静默插件插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class UnSleepPlugin extends CqPlugin {



    private final SleepCache sleepCache;

    public UnSleepPlugin(SleepCache sleepCache) {
        this.sleepCache = sleepCache;
    }

    @MessageMapping(equal = {"unSleep", "unQuiet", "醒醒"}, at = true, type = MessageMappingTypeEnum.ALL)
    public String sleep(MessageParam<SleepParam> param, CqTemplate cqTemplate) {
        sleepCache.removeFlag(param.getIsGroup(), param.getRegisterId());
        return "醒了醒了";
    }

}
