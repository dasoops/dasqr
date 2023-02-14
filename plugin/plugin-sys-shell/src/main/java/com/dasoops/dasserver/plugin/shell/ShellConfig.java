package com.dasoops.dasserver.plugin.shell;

import com.dasoops.dasserver.plugin.shell.entity.enums.ShellRunMessageTypeEnum;
import lombok.Data;

/**
 * @title: ShellConfig
 * @classPath com.dasoops.dasserver.plugin.shell.ShellConfig
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/23
 * @version 1.0.0
 * @description shell配置
 */
@Data
public class ShellConfig {

    private ShellRunMessageTypeEnum type = ShellRunMessageTypeEnum.GROUP;

    private Long groupId;

    private Long userId;

    private Long selfId;
}
