package com.dasoops.dasserver.plugin.sleep;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: SleepPlugin
 * @ClassPath com.dasoops.dasserver.plugin.sleep.SleepPlugin
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

    @MessageMapping(prefix = {"unSleep", "unQuiet", "醒醒"}, type = MessageMappingTypeEnum.ALL)
    public String sleep(SleepParam param) {
        sleepCache.removeFlag(param.getIsGroup(), param.getRegisterId());
        return "醒了醒了";
    }

}
