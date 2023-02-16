package com.dasoops.dasserver.cq;

import com.dasoops.dasserver.cq.entity.dto.cq.event.CqEvent;
import lombok.Getter;

/**
 * @title PassObj
 * @classPath com.dasoops.dasserver.cq.PassObj
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 插件判断放行对象
 */
public class PassObj {

    /**
     * 是否通过 true为通过,false为拦截
     */
    @Getter
    private boolean isPass;

    /**
     * 参数
     */
    @Getter
    private CqEvent event;

    private PassObj() {

    }

    /**
     * 带参放行,参数将传递给下一个拦截器
     *
     * @param event event
     * @return {@link PassObj}
     */
    public static PassObj pass(CqEvent event) {
        PassObj passObj = new PassObj();
        passObj.isPass = true;
        passObj.event = event;
        return passObj;
    }

    /**
     * 阻塞
     *
     * @return {@link PassObj}
     */
    public static PassObj block() {
        PassObj passObj = new PassObj();
        passObj.isPass = false;
        return passObj;
    }
}