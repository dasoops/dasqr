package com.dasoops.dasq.core.cq.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: CqHttp
 * @ClassPath com.dasoops.dasq.controller.TestController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/03
 * @Version 1.0.0
 * @Description: CqHttp消息处理
 */
@RestController
@RequestMapping
@Slf4j
public class CqController {

    @PostMapping
    public String onMessage(@RequestBody JSONObject getJson) {
        String postType = (String) getJson.get("post_type");
        log.info(postType);
        log.info(JSON.toJSONString(getJson));
        return "null";
    }

    @GetMapping
    public void test1(String json){
        log.info("get");
    }
}
