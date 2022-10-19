package com.dasoops.dasq.core.cq.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.common.util.WebUtil;
import com.dasoops.dasq.core.cq.entity.dto.CqRes;
import com.dasoops.dasq.core.cq.entity.dto.CqResData;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.service.CqService;
import com.dasoops.dasq.core.dq.methodstrategy.entity.GetMsgDto;
import com.dasoops.dasq.core.dq.methodstrategy.entity.MsgData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
        Map<String, String> paramMap = null;

        //拼接参数地址
        paramMap = Map.of(
                isGroup ? CqKeywordEnum.GROUP_ID.getOtherName() : CqKeywordEnum.USER_ID.getOtherName(), String.valueOf(receiveId),
                CqKeywordEnum.MESSAGE.getSimpleName(), msg
        );

        ResponseEntity<Object> resp = get2Cq(baseUrl, paramMap);
        Long messageId = 0L;

        //go_cqhttp返回值再次判断
        CqRes cqRes = BeanUtil.toBean(resp.getBody(), CqRes.class);
        if (cqRes.getStatus().equals(CqKeywordEnum.CQ_RES_STATUS_FAILED.getSimpleName())) {
            CqResData data = cqRes.getData();
            messageId = data.getMessageId();
        }

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

    @Override
    public String getMessage(String messageId) {
        String baseUrl = dasqProperties.getCqHttpUrl() +
                CqKeywordEnum.URL_SEPARATOR.getSimpleName() +
                CqKeywordEnum.GET_MESSAGE.getOtherName();

        Map<String, String> paramMap = null;

        //拼接参数地址
        paramMap = Map.of("message_id", messageId);

        ResponseEntity<Object> resp = get2Cq(baseUrl, paramMap);
        GetMsgDto getMsgDto = JSON.parseObject(JSON.toJSONString(resp.getBody()), GetMsgDto.class);
        MsgData msgData = getMsgDto.getMsgData();

        return StrUtil.format("{}({}) : \r\n{}", msgData.getSender().getNickname(), DateUtil.date(1000L * msgData.getTime()), msgData.getMessage());
    }

    private ResponseEntity<Object> get2Cq(String baseUrl, Map<String, String> paramMap) {
        ResponseEntity<Object> resp = null;
        try {
            UriComponentsBuilder finalBuilder = UriComponentsBuilder.fromUriString(baseUrl);
            paramMap.forEach((key, value) -> finalBuilder.queryParam(key, URLEncoder.encode(value, StandardCharsets.UTF_8)));
            URI uri = finalBuilder.build(true).toUri();

            var httpEntity = WebUtil.getAuthHttpEntity(dasqProperties.getToken());

            //发送请求
            resp = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Object.class);
            //http返回值判断
            if (resp.getStatusCode() != HttpStatus.OK || resp.getBody() == null) {
                throw new LogicException(ExceptionCodeEnum.CQ_HTTP_ERROR, JSON.toJSONString(resp));
            }
        } catch (Exception e) {
            throw new LogicException(ExceptionCodeEnum.CQ_HTTP_ERROR, JSON.toJSONString(resp) + "\n" + ExceptionUtil.stacktraceToString(e));
        }
        log.debug("命令执行成功:{}", resp.getBody());
        return resp;
    }
}
