package com.dasoops.dasserver.plugin.reboot.plugin;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.enums.ConfigHashKeyEnum;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.ServerModeEnum;
import com.dasoops.dasserver.cq.entity.event.message.MappingMessage;
import com.dasoops.dasserver.plugin.exec.ExecTemplate;
import com.dasoops.dasserver.plugin.reboot.entity.enums.QuietRebootEnum;
import com.dasoops.dasserver.plugin.reboot.entity.enums.RebootConfigHashKeyEnum;
import com.dasoops.dasserver.plugin.reboot.entity.param.RebootParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: plugin
 * @ClassPath com.dasoops.dasserver.core.plugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 插件
 * @see CqPlugin
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RebootPlugin extends CqPlugin {

    private final ConfigCache configCache;
    private final ExecTemplate execTemplate;

    @SuppressWarnings("all")
    @MessageMapping(equal = {"reboot", "rebootServer", "rebootWeb"}, at = true, type = MessageMappingTypeEnum.ALL)
    public String reboot(CqTemplate cqTemplate, MappingMessage<RebootParam> param) {
        if (!configCache.getIntegerConfig(ConfigHashKeyEnum.SERVER_MODE).equals(ServerModeEnum.PROD.getDbValue())) {
            return "dev环境无法使用reboot指令";
        }
        QuietRebootEnum quietRebootEnum = configCache.getEnumConfig(RebootConfigHashKeyEnum.QUIET_REBOOT, QuietRebootEnum.class);
        boolean quietReboot = quietRebootEnum.equals(QuietRebootEnum.FALSE);
        if (quietReboot) {
            cqTemplate.sendMsg(param, "gogogo");
        }
        //改start会有问题,同步异步
        try {
            execTemplate.exec(param.getMatchKeyword());
        } catch (LogicException e) {
            return StrUtil.format("未配置reboot文件路径(dasq.plugin.exec.execPluginMap.{})",param.getMatchKeyword());
        }
        if (quietReboot) {
            return "compile complete, to reboot";
        }
        return null;
    }

}
