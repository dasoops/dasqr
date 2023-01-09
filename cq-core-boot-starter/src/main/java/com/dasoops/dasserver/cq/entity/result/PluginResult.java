package com.dasoops.dasserver.cq.entity.result;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: Result
 * @ClassPath com.dasoops.dasserver.cq.entity.result.Result
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: 结果
 */
public class PluginResult {

    @Getter
    private final List<String> messageList = new ArrayList<>();

    public static PluginResult of(String... message) {
        PluginResult pluginResult = new PluginResult();
        pluginResult.messageList.addAll(Arrays.stream(message).toList());
        return pluginResult;
    }

    public static PluginResult of(List<String> messageList) {
        PluginResult pluginResult = new PluginResult();
        pluginResult.messageList.addAll(messageList);
        return pluginResult;
    }

    public void add(String message) {
        this.messageList.add(message);
    }

}
