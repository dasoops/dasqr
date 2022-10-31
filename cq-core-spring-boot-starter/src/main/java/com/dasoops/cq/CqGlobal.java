package com.dasoops.cq;

import com.dasoops.cq.bot.CqTemplate;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: WsConnection
 * @ClassPath com.dasoops.cq.websocket.WsConnection
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
}
