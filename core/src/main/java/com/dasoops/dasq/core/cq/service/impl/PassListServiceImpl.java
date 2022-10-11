package com.dasoops.dasq.core.cq.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasq.core.cq.entity.bo.MethodTypeAndInfoBo;
import com.dasoops.dasq.core.cq.entity.bo.PassKeywordGetMethodInfoIdBo;
import com.dasoops.dasq.core.cq.entity.enums.CqRedisKeyEnum;
import com.dasoops.dasq.core.cq.entity.po.MethodInfo;
import com.dasoops.dasq.core.cq.service.PassListService;
import com.dasoops.dasq.core.cq.entity.po.PassObject;
import com.dasoops.dasq.core.cq.mapper.PassListMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_PASS_LIST(过滤白名单)】的数据库操作Service实现
 * @createDate 2022-10-07 16:40:31
 */
@Service
@Slf4j
public class PassListServiceImpl extends ServiceImpl<PassListMapper, PassObject>
        implements PassListService {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;

    @Resource
    private PassListMapper passListMapper;

    @Override
    public void initOrUpdate() {
        initOrUpdatePassListKeywordGetMethodInfoMap2Redis();
        initOrUpdatePassListTypeGetEntityJsonSetMap2Redis();
    }

    private void initOrUpdatePassListTypeGetEntityJsonSetMap2Redis() {
        log.info("初始化/更新 PassListTypeGetEntityJsonSetMap 数据至redis");

        //清除旧数据
        redisTemplate.delete(CqRedisKeyEnum.PASS_LIST_TYPE_GET_ENTITY_JSON_SET_MAP.getRedisKey());

        //查询数据库,构建集合
        List<PassObject> list = super.lambdaQuery().ne(PassObject::getEnable, 0).list();

        Map<String, String> resMap = list.stream()
                .collect(Collectors.groupingBy(PassObject::getType))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        res -> String.valueOf(res.getKey()),
                        res -> JSON.toJSONString(res.getValue())
                ));

        //存入
        redisTemplate.opsForHash().putAll(CqRedisKeyEnum.PASS_LIST_TYPE_GET_ENTITY_JSON_SET_MAP.getRedisKey(), resMap);

        log.info("完成: 初始化/更新 PassListTypeGetEntityJsonSetMap 数据至redis,Data:{}", JSON.toJSONString(resMap));
    }

    private void initOrUpdatePassListKeywordGetMethodInfoMap2Redis() {
        log.info("初始化/更新 白名单关键词-方法info id映射集合 数据至redis");
        List<PassKeywordGetMethodInfoIdBo> boList = getPassListKeywordGetMethodInfoList();
        Map<String, String> resMap = boList.stream().collect(Collectors.toMap(PassKeywordGetMethodInfoIdBo::getKeyword, res -> String.valueOf(res.getId())));
        redisTemplate.opsForHash().putAll(CqRedisKeyEnum.PASS_LIST_KEYWORD_GET_METHOD_INFO_ID_MAP.getRedisKey(), resMap);
        log.info("完成: 初始化/更新 白名单关键词-方法info id映射集合 数据至redis,Data:{}", JSON.toJSONString(resMap));
    }

    @Override
    public Optional<List<PassObject>> getPassListByType(Integer type) {
        String jsonStr = (String) redisTemplate.opsForHash().get(CqRedisKeyEnum.PASS_LIST_TYPE_GET_ENTITY_JSON_SET_MAP.getRedisKey(), String.valueOf(type));
        if (jsonStr == null) {
            return Optional.empty();
        }
        return Optional.of(JSON.parseArray(jsonStr).toList(PassObject.class));
    }

    @Override
    public List<PassKeywordGetMethodInfoIdBo> getPassListKeywordGetMethodInfoList() {
        return passListMapper.selectPassKeywordGetMethodInfoMap();
    }

    @Override
    public MethodTypeAndInfoBo getMethodInfoByPassKeyword(String keyword) {
        return passListMapper.selectMethodInfoAndTypeByPassKeyword(keyword);
    }
}