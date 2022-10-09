package com.dasoops.dasq.core.cq.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasq.core.cq.entity.enums.CqRedisKeyEnum;
import com.dasoops.dasq.core.cq.entity.pojo.MethodInfo;
import com.dasoops.dasq.core.cq.service.MethodInfoService;
import com.dasoops.dasq.core.cq.mapper.MethodInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【TB_CQ_METHOD_INFO】的数据库操作Service实现
 * @createDate 2022-10-09 16:46:22
 */
@Service
@Slf4j
public class MethodInfoServiceImpl extends ServiceImpl<MethodInfoMapper, MethodInfo>
        implements MethodInfoService {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;

    @Override
    public void initOrUpdateMethodInfoIdEntityJson2Redis() {
        log.info("初始化/更新 MethodInfo Id-EntityJson 数据至redis");

        //清除旧数据
        redisTemplate.delete(CqRedisKeyEnum.METHOD_INFO_ID_GET_ENTITY_JSON_MAP.getRedisKey());

        //查询数据库,构建集合
        List<MethodInfo> list = super.lambdaQuery().list();
        Map<String, String> resMap = list.stream().collect(Collectors.toMap(
                res -> String.valueOf(res.getId()),
                JSON::toJSONString
        ));

        //存入
        redisTemplate.opsForHash().putAll(CqRedisKeyEnum.METHOD_INFO_ID_GET_ENTITY_JSON_MAP.getRedisKey(), resMap);

        log.info("完成: 初始化/更新 MethodInfo Id-EntityJson 数据至redis,Data:{}", JSON.toJSONString(resMap));
    }
}




