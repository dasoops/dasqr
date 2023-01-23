package com.dasoops.dasserver.plugin.shell;

import com.dasoops.dasserver.plugin.shell.entity.enums.ShellMessageTypeEnum;
import lombok.Data;

/**
 * @Title: ShellConfig
 * @ClassPath com.dasoops.dasserver.plugin.shell.ShellConfig
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/23
 * @Version 1.0.0
 * @Description: shell配置
 */
@Data
public class ShellConfig {

    private ShellMessageTypeEnum type = ShellMessageTypeEnum.GROUP;

    private Long groupId;

    private Long userId;

    private Long selfId;
}
