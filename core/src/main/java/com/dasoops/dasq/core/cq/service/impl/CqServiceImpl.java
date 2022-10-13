package com.dasoops.dasq.core.cq.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.entity.dto.CqRes;
import com.dasoops.dasq.core.cq.service.CqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Title: CqServiceImpl
 * @ClassPath com.dasoops.dasq.core.cq.service.impl.CqServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: cq服务impl
 * @see CqService
 */
@Service
@Slf4j
public class CqServiceImpl implements CqService {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DasqProperties dasqProperties;


    @Override
    public Long sendMsg(Boolean isGroup, Long receiveId, String msg) {
        String baseUrl = dasqProperties.getCqHttpUrl() +
                CqKeywordEnum.URL_SEPARATOR.getSimpleName() +
                (isGroup ? CqKeywordEnum.SEND_GROUP_MSG.getOtherName() : CqKeywordEnum.SEND_PRIVATE_MSG.getOtherName());

        //拼接参数地址
        Map<String, String> paramMap = Map.of(
                isGroup ? CqKeywordEnum.GROUP_ID.getOtherName() : CqKeywordEnum.USER_ID.getOtherName(), String.valueOf(receiveId),
                CqKeywordEnum.MESSAGE.getSimpleName(), msg
        );
        String url = WebUtil.getParametersUrl(baseUrl, paramMap);

        var httpEntity = WebUtil.getAuthHttpEntity(dasqProperties.getToken());

        ResponseEntity<Object> resp;
        Long messageId = -1L;
        CqRes cqRes = null;
        try {
            //发送请求
            resp = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Object.class, paramMap);
            //http返回值判断
            if (resp.getStatusCode() != HttpStatus.OK || resp.getBody() == null) {
                throw new LogicException(ExceptionCodeEnum.CQ_HTTP_ERROR, JSON.toJSONString(resp));
            }

            //go_cqhttp返回值再次判断
            cqRes = BeanUtil.toBean(resp.getBody(), CqRes.class);
            if (cqRes.getStatus().equals(CqKeywordEnum.CQ_RES_STATUS_FAILED.getSimpleName())) {
                messageId = cqRes.getData().getMessageId();
            }

        } catch (Exception e) {
            throw new LogicException(ExceptionCodeEnum.CQ_HTTP_ERROR, cqRes.getMsg());
        }

        log.debug("命令执行成功:{}", resp.getBody());
        return messageId;
    }

    @Override
    public Long sendMsg(String msg) {
        EventInfo eventInfo = EventUtil.get();
        String messageType = String.valueOf(eventInfo.getMessageType());

        if (messageType.equals(CqKeywordEnum.MESSAGE_TYPE_GROUP.getOtherName())) {
            return sendMsg(true, eventInfo.getGroupId(), msg);
        }

        if (messageType.equals(CqKeywordEnum.MESSAGE_TYPE_PRIVATE.getOtherName())) {
            return sendMsg(false, eventInfo.getAuthorId(), msg);
        }

        return null;
    }
}
