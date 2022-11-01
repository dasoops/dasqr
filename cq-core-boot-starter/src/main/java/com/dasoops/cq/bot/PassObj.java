package com.dasoops.cq.bot;

import com.dasoops.cq.entity.event.CqEvent;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * @Title: PassObj
 * @ClassPath com.dasoops.cq.bot.PassObj
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 插件判断放行对象
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
    private Optional<CqEvent> param;

    private PassObj() {

    }

    /**
     * 放行
     *
     * @return {@link PassObj}
     */
    public static PassObj pass() {
        PassObj passObj = new PassObj();
        passObj.isPass = true;
        return passObj;
    }

    /**
     * 带参放行,参数将传递给下一个拦截器
     *
     * @param param 参数
     * @return {@link PassObj}
     */
    public static PassObj pass(CqEvent param) {
        PassObj passObj = new PassObj();
        passObj.isPass = true;
        passObj.param = Optional.of(param);
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