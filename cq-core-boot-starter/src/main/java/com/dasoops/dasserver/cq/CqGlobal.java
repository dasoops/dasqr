package com.dasoops.dasserver.cq;

import com.dasoops.dasserver.cq.bot.CqTemplate;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Title: WsConnection
 * @ClassPath com.dasoops.dasserver.cq.websocket.WsConnection
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: ws连接
 */
@Getter
@Setter
public class CqGlobal {
    /**
     * cq集合
     * Map<QId,CqTemplate>
     */
    public static Map<Long, CqTemplate> robots = new HashMap<>();

    public static Optional<CqTemplate> findFirst(){
        return CqGlobal.robots.values().stream().findFirst();
    }
}
