package com.dasoops.dasserver.cq.api;


import com.alibaba.fastjson2.JSONObject;

/**
 * @title IApiRequest
 * @classPath com.dasoops.dasserver.cq.api.IApiRequest
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/03
 * @version 1.0.0
 * @description 自定义API可以实现这个接口
 * 使用cq.callCustomApi(IApiRequest apiRequest)
 */
public interface IApiRequest {
    /**
     * 获取url
     *
     * @return {@link String}
     */
    String getUrl();

    /**
     * 获取参数
     *
     * @return {@link JSONObject}
     */
    JSONObject getParams();
}
