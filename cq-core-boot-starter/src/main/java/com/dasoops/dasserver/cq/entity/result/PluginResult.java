package com.dasoops.dasserver.cq.entity.result;

import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title Result
 * @classPath com.dasoops.dasserver.cq.entity.result.Result
 * @date 2023/01/09
 * @description 结果
 */
public class PluginResult {

    @Getter
    protected final List<String> messageList = new ArrayList<>();

    @Setter
    private static String fastFailImageUrl = null;

    /**
     * 快速失败
     * 需要改进的东西,但是暂时还没想好,直接导包太蠢了,解析器感觉duck不必
     *
     * @return {@link PluginResult}
     */
    public static PluginResult fastFail() {
        return PluginResult.of("怎么这都不会", fastFailImageUrl == null ? null : CqCodeUtil.image(fastFailImageUrl));
    }

    public static PluginResult build() {
        return new PluginResult();
    }

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
