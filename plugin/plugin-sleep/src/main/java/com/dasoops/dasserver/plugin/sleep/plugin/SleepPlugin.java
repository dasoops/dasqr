package com.dasoops.dasserver.plugin.sleep.plugin;

import com.dasoops.common.util.TimeUtil;
import com.dasoops.common.util.entity.TimeDto;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.utils.CqMessageAssert;
import com.dasoops.dasserver.plugin.sleep.cache.SleepCache;
import com.dasoops.dasserver.plugin.sleep.entity.param.SleepParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Title: SleepPlugin
 * @ClassPath com.dasoops.dasserver.plugin.sleep.plugin.SleepPlugin
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

    @MessageMapping(prefix = {"sleep", "quiet", "打晕", "闭嘴", "shutUp"}, at = true, type = MessageMappingTypeEnum.ALL)
    public String sleep(MessageParam<SleepParam> param) {
        CqMessageAssert.getInstance().allMustNotNull(param);

        TimeDto timeDto;
        String sleepTimeString = param.getParam().getSleepTimeString();
        if (null == sleepTimeString || "".equals(sleepTimeString)) {
            timeDto = TimeDto.builder().count(10L).timeUnit(TimeUnit.MINUTES).build();
        } else {
            //分离单位和时间
            timeDto = TimeUtil.cutTimeUnitAndTimeCount(sleepTimeString);
        }
        sleepCache.sleep(param.getIsGroup(), param.getRegisterId(), timeDto.getCount(), timeDto.getTimeUnit());

        switch (param.getMatchKeyword()) {
            case "quiet" -> {
                return null;
            }
            case "打晕" -> {
                return "@&o%a*e()$~";
            }
            case "shutUp", "闭嘴" -> {
                return "呜呜呜~";
            }
        }
        return "zzZZZZzzzzzz";
    }

}
