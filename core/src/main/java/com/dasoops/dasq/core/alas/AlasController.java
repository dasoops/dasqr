package com.dasoops.dasq.core.alas;

import cn.hutool.json.JSONObject;
import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.common.util.KeywordUtil;
import com.dasoops.dasq.core.cq.service.CqService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Title: AlasController
 * @ClassPath com.dasoops.dasq.core.alas.AlasController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/13
 * @Version 1.0.0
 * @Description: 唉控制器
 */
@RestController
@RequestMapping("/alas")
public class AlasController {

    @Resource
    private CqService cqService;
    @Resource
    private DasqProperties dasqProperties;

    @PostMapping("/error")
    public void alasError(@RequestBody JSONObject paramObject) {
        String msg = paramObject.getStr("content").split("> ")[1];

        cqService.sendMsg(true, Long.valueOf(dasqProperties.getDevGroupId()),
                KeywordUtil.buildAtCqCode(dasqProperties.getAdminId()) + "Alas模块发生异常,请求人类接管,errorMsg: \r\n"
                        + msg);
    }
}
