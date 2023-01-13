package com.dasoops.dasserver.plugin.echo.plugin;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.param.base.SimpleParam;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.event.message.MappingMessage;
import com.dasoops.dasserver.plugin.echo.cache.EchoCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @Title: CacheEchoPlugin
 * @ClassPath com.dasoops.dasserver.plugin.cacheecho.plugin.EchoPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/116
 * @Version 1.0.0
 * @Description: echo插件
 * @see CqPlugin
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class EchoPlugin extends CqPlugin {

    private final EchoCache echoCache;

    @MessageMapping(prefix = {"echo", "print", "printf"}, type = MessageMappingTypeEnum.ALL)
    public String echo(MappingMessage<SimpleParam> param, CqMessageEvent messageEvent) {
        //获取移除前缀后的消息
        String message = messageEvent.getMessage();
        String matchKeyword = param.getMatchKeyword();
        String echoMessage = StrUtil.removePrefix(message, matchKeyword + " ");

        //是否为缓存
        final String cachePrefix = "$";
        if (!StrUtil.startWith(echoMessage, cachePrefix)) {
            return echoMessage;
        }

        //移除缓存前缀
        String cacheKeyword = StrUtil.removePrefix(echoMessage, cachePrefix);
        Set<String> keySet = echoCache.keys(cacheKeyword);
        if (keySet.size() <= 0) {
            return "None";
        } else if (keySet.size() > 1) {
            List<String> keyList = keySet.stream().map(key -> cachePrefix + key).toList();
            return StrUtil.format("any Result:[{}]", StrUtil.join(",", keyList));
        } else {
            return echoCache.get(keySet.iterator().next());
        }
    }
}
