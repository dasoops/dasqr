package com.dasoops.dasserver.plugin.shell.param;

import com.alibaba.fastjson2.JSON;
import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.dasserver.plugin.shell.entity.vo.LogDto;
import com.dasoops.dasserver.plugin.shell.enums.ShellSendMessageTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ShellMessage
 * @ClassPath com.dasoops.dasserver.plugin.shell.param.ShellMessage
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/25
 * @Version 1.0.0
 * @Description: shell消息
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShellMessageVo extends SimpleParam {

    private ShellSendMessageTypeEnum type;

    private String msg;

    private ShellMessageVo() {

    }

    public static ShellMessageVo log(LogDto logDto) {
        ShellMessageVo shellMessageVo = new ShellMessageVo();
        shellMessageVo.setMsg(JSON.toJSONString(logDto));
        shellMessageVo.setType(ShellSendMessageTypeEnum.LOG);
        return shellMessageVo;
    }

    public static ShellMessageVo msg(String msg) {
        ShellMessageVo shellMessageVo = new ShellMessageVo();
        shellMessageVo.setMsg(msg);
        shellMessageVo.setType(ShellSendMessageTypeEnum.MESSAGE);
        return shellMessageVo;
    }

}
