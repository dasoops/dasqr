package com.dasoops.dasserver.cq.api;


import com.alibaba.fastjson2.JSONObject;

/**
 * @Title: IApiRequest
 * @ClassPath com.dasoops.dasserver.cq.api.IApiRequest
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: 自定义API可以实现这个接口
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
