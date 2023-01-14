package com.dasoops.dasserver.plugin.alasnotice.controller;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqGlobal;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.alasnotice.entity.enums.AlasConfigHashKeyEnum;
import com.dasoops.dasserver.plugin.alasnotice.entity.enums.AlasExceptionEnum;
import com.dasoops.dasserver.plugin.alasnotice.entity.enums.AlasNoticeTypeEnum;
import com.dasoops.dasserver.plugin.alasnotice.entity.param.AlasErrorParam;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Title: AlasController
 * @ClassPath com.dasoops.dasserver.plugin.template.controller.AlasController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: alas控制器
 */
@RequestMapping("alas")
@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "PLUGIN - ALAS_NOTICE")
@ApiSupport(author = "DasoopsNicole@gmail.com")
public class AlasController {

    private final ConfigCache configCache;

    @PostMapping("error")
    @ApiOperation(value = "alasError消息上报", notes = "alasError消息上报")
    public String error(@RequestBody AlasErrorParam param) {
        List<Long> xSelfIdList = param.getXSelfIdList();

        AlasNoticeTypeEnum noticeTypeEnum = configCache.getEnumConfig(AlasConfigHashKeyEnum.ALAS_NOTICE_TYPE, AlasNoticeTypeEnum.class);
        Long groupId = configCache.getLongConfig(AlasConfigHashKeyEnum.ALAS_NOTICE_GROUP);
        Long userId = configCache.getLongConfig(AlasConfigHashKeyEnum.ALAS_NOTICE_USER);

        //构建发送消息
        final SendMessageFunction function;
        switch (noticeTypeEnum) {
            case GROUP -> function = (cqTemplate, message) -> cqTemplate.sendGroupMsg(groupId, message, false);
            case PRIVATE -> function = (cqTemplate, message) -> cqTemplate.sendPrivateMsg(groupId, message, false);
            case GROUP_AT_USER -> function = (cqTemplate, message) -> cqTemplate.sendGroupMsg(groupId, CqCodeUtil.at(userId) + message, false);
            default -> {
                return "noNotice";
            }
        }

        //构建发送消息
        String messageFormat = """
                AlasError:
                  title: {}
                  context: {}
                """;
        String massage = StrUtil.format(messageFormat, param.getTitle(), param.getContent());

        if (xSelfIdList == null || xSelfIdList.size() == 0){
            throw new LogicException(AlasExceptionEnum.NO_NOTICE_CQ_TEMPLATE);
        }
        for (Long xSelfId : xSelfIdList) {
            CqTemplate cqTemplate = CqGlobal.get(xSelfId);
            if (cqTemplate == null) {
                continue;
            }
            function.send(cqTemplate, massage);
        }

        return "success";
    }

    interface SendMessageFunction {
        void send(CqTemplate cqTemplate, String message);
    }

}
