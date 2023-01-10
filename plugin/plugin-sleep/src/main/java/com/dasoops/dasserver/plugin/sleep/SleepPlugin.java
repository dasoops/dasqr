package com.dasoops.dasserver.plugin.sleep;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Title: SleepPlugin
 * @ClassPath com.dasoops.dasserver.plugin.sleep.SleepPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/10
 * @Version 1.0.0
 * @Description: 静默插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class SleepPlugin extends CqPlugin {

    private final SleepCache sleepCache;

    public SleepPlugin(SleepCache sleepCache) {
        this.sleepCache = sleepCache;
    }

    @MessageMapping(prefix = {"sleep", "quiet", "打晕", "shutUp"}, type = MessageMappingTypeEnum.ALL)
    public String sleep(SleepParam param) {
        if (param != null) {
            return "aoe";
        }
        //分离单位和时间
        String sleepTimeString = param.getSleepTimeString();
        int[] sleepTimeChars = sleepTimeString.chars().toArray();
        StringBuilder timeUnitString = new StringBuilder();
        int timeEndIndex = 0;
        for (int i = 0; i < sleepTimeChars.length; i++) {
            int timeChar = sleepTimeChars[i];
            if (timeChar >= '0' && timeChar <= '9') {
                timeEndIndex = i + 1;
                continue;
            }
            timeUnitString.append((char) timeChar);
        }

        TimeUnit timeUnit;
        switch (timeUnitString.toString()) {
            case "m", "min", "minute", "minutes" -> timeUnit = TimeUnit.MINUTES;
            case "h", "hour" -> timeUnit = TimeUnit.HOURS;
            case "d", "day", "days" -> timeUnit = TimeUnit.DAYS;
            default -> timeUnit = TimeUnit.SECONDS;
        }
        Long time = Long.valueOf(sleepTimeString.substring(0, timeEndIndex));

        sleepCache.sleep(param.getIsGroup(), param.getRegisterId(), time, timeUnit);
        return "zzZZZZzzzzzz...";
    }

}
