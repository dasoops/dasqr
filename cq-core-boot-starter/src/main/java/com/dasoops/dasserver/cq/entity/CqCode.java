package com.dasoops.dasserver.cq.entity;

import lombok.Data;

import java.util.Map;

/**
 * @Title: CqCode
 * @ClassPath com.dasoops.dasserver.cq.entity.CqCode
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/07
 * @Version 1.0.0
 * @Description: cq码解析后对象
 */
@Data
public class CqCode {

    /**
     * 类型
     */
    private String type;

    /**
     * 参数个数
     */
    private Map<String, String> param;

}
