package com.dasoops.dasserver.plugin.setu;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.plugin.setu.entity.dto.SetuInfoDto;
import com.dasoops.dasserver.plugin.setu.entity.dto.SetuResultDto;
import com.dasoops.dasserver.plugin.setu.entity.enums.SetuConfigRedisHashKeyEnum;
import com.dasoops.dasserver.plugin.setu.entity.enums.SetuExceptionEnum;
import com.dasoops.dasserver.plugin.setu.entity.param.SetuParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

/**
 * @title: SetuTemplate
 * @classPath com.dasoops.dasserver.plugin.setu.SetuTemplate
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/22
 * @version 1.0.0
 * @description setu模板
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SetuTemplate {

    private final ConfigCache configCache;
    private final RestTemplate restTemplate;

    /**
     * 获取api完整返回对象
     *
     * @param param param
     * @return setu对象
     */
    public SetuInfoDto getSetuInfo(SetuParam param) {
        //组装请求
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept-Charset", "application/json;charset=utf-8");
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
        headers.add("Accept-Encoding", "gzip, deflate, br");

        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(param), headers);

        String apiUrl = configCache.getStringConfig(SetuConfigRedisHashKeyEnum.API_REQUEST_BASE_URL);
        //发送请求,接收数据
        ResponseEntity<SetuResultDto> setuResponseEntity;
        try {
            setuResponseEntity = restTemplate.postForEntity(apiUrl, httpEntity, SetuResultDto.class);
        } catch (Exception e) {
            log.error("", e);
            throw new LogicException(SetuExceptionEnum.API_REQUEST_ERROR, ExceptionUtil.stacktraceToString(e));
        }
        if (!setuResponseEntity.getStatusCode().equals(HttpStatus.OK)) {
            throw new LogicException(SetuExceptionEnum.API_REQUEST_ERROR);
        }
        List<SetuInfoDto> setuInfoDtoList = Objects.requireNonNull(setuResponseEntity.getBody()).getData();
        if (setuInfoDtoList.size() <= 0) {
            return null;
        }
        return setuInfoDtoList.get(0);
    }

}
