package com.dasoops.dasq.core.cq.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasq.core.cq.entity.dto.CqMessageReq;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.entity.po.MethodInfo;
import com.dasoops.dasq.core.cq.entity.po.PassObject;
import com.dasoops.dasq.core.cq.methodstrategy.strategycontext.CqMethodStrategyContext;
import com.dasoops.dasq.core.cq.methodstrategy.strategycontext.CqMethodStrategyContextFactory;
import com.dasoops.dasq.core.cq.service.MethodInfoService;
import com.dasoops.dasq.core.cq.service.PassListService;
import com.dasoops.dasq.core.cq.util.CqKeywordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
public class CqBaseController {

    @Resource
    private MethodInfoService methodInfoService;
    @Resource
    private PassListService passListService;
    @Resource
    private CqMethodStrategyContextFactory factory;

    @PostMapping
    public void onMessage(@RequestBody CqMessageReq req) {
        //获取策略上下文对象
        CqMethodStrategyContext context = factory.getContext();

        //获取消息
        String message = req.getMessage();

        //获取关键词集合
        Optional<List<PassObject>> passListOpt = passListService.getPassListByType(Integer.parseInt(CqKeywordEnum.MESSAGE_TYPE_MESSAGE_PREFIX.getOtherName()));
        if (passListOpt.isEmpty()) {
            return;
        }
        List<String> keywordList = passListOpt.get().stream().map(PassObject::getPassKeyword).collect(Collectors.toList());

        CqKeywordUtil.getMatchKeyword(message, keywordList).ifPresent(res -> {
            context.invoke(methodInfoService.getMethodInfoIdByKeyWord(res), req.getMessage());
        });
    }

}
