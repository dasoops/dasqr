package com.dasoops.dasserver.plugin.reboot;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title: RebootProperties
 * @ClassPath com.dasoops.dasserver.plugin.reboot.RebootProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: 重启参数
 */
@ConfigurationProperties(prefix = "dasq.plugin.reboot")
@Getter
@Setter
public class RebootProperties {

    /**
     * reboot文件路径
     */
    private String rebootShellFilePath;

}
