package com.dasoops.dasserver.plugin.template;

import com.alibaba.fastjson2.JSONObject;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title: AlasController
 * @ClassPath com.dasoops.dasserver.plugin.template.AlasController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: alas控制器
 */
@RequestMapping("alas")
@RestController
@RequiredArgsConstructor
@Slf4j
public class AlasController {

    private final ConfigCache configCache;

    @PostMapping("error")
    public String error(@RequestBody JSONObject param) {
        log.info(param.toJSONString());
//        List<Long> xSelfIdList = param.getXSelfIdList();
//
//        AlasNoticeTypeEnum noticeTypeEnum = EnumUtil.getBy(AlasNoticeTypeEnum::getDbValue, configCache.getIntegerConfig(AlasConfigHashKeyEnum.ALAS_NOTICE_TYPE));
//        Long groupId = configCache.getLongConfig(AlasConfigHashKeyEnum.ALAS_NOTICE_GROUP);
//        Long userId = configCache.getLongConfig(AlasConfigHashKeyEnum.ALAS_NOTICE_USER);
//
//        String message =
//
//        xSelfIdList.forEach(xSelfId -> {
//            CqTemplate cqTemplate = CqGlobal.get(xSelfId);
//            switch (noticeTypeEnum) {
//                case GROUP -> cqTemplate.sendGroupMsg(groupId,)
//                case PRIVATE ->
//                case GROUP_AT_USER ->
//            }
//        });
        return "success";
    }

}
