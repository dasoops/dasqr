package com.dasoops.dasq.core.common.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.RedisKeyEnum;
import com.dasoops.dasq.core.common.entity.pojo.Dictionary;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.common.mapper.DictionaryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_DICTIONARY】的数据库操作Service实现
 * @createDate 2022-10-09 11:10:23
 */
@Service
@Slf4j
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary>
        implements DictionaryService {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;

    @Override
    public void initOrUpdateDictTreeData2Redis() {
        log.info("初始化/更新 DictionaryTreeData 数据至redis");

        //清除旧数据
        redisTemplate.delete(RedisKeyEnum.CORE_DICT_DICT_CODE_GET_FATHER_ID_MAP_HASH.getRedisKey());

        //查询数据库,构建集合
        List<Dictionary> list = super.lambdaQuery().ne(Dictionary::getHasChild, 0).list();
        Map<String, String> map = list.stream().collect(Collectors.toMap(Dictionary::getDictCode, res -> String.valueOf(res.getId())));

        //存入
        redisTemplate.opsForHash().putAll(RedisKeyEnum.CORE_DICT_DICT_CODE_GET_FATHER_ID_MAP_HASH.getRedisKey(), map);

        log.info("完成: 初始化/更新 DictionaryTreeData 数据至redis,Data:{}", JSON.toJSONString(map));
    }

    @Override
    public void initOrUpdateDictFatherDictCodeMap2Redis() {
        log.info("初始化/更新 DictFatherDictCodeMap 数据至redis");

        //清除旧数据
        redisTemplate.delete(RedisKeyEnum.CORE_DICT_ID_GET_CHILD_DICT_INFO_MAP_JSON_MAP.getRedisKey());

        //查询数据库,构建集合
        List<Dictionary> list = super.lambdaQuery().list();
        Map<Long, Map<String, String>> map = new HashMap<>(16);
        list.forEach(res -> {
            if (res.getHasChild() != 0) {
                map.put(res.getId(), new HashMap<>(16));
            } else {
                map.get(res.getParentId()).put(res.getDictCode(), res.getDictValue());
            }
        });

        Map<String, String> resMap = map.entrySet().stream().collect(Collectors.toMap(
                res -> String.valueOf(res.getKey()),
                res -> JSON.toJSONString(res.getValue())
        ));

        //存入
        redisTemplate.opsForHash().putAll(RedisKeyEnum.CORE_DICT_ID_GET_CHILD_DICT_INFO_MAP_JSON_MAP.getRedisKey(), resMap);

        log.info("完成: 初始化/更新 DictFatherDictCodeMap 数据至redis,Data:{}", JSON.toJSONString(map));
    }

    @Override
    public String getDictionaryById(Long fatherId, String dictCode) {
        Map<String, String> map = getDictionaryMapByFatherId(fatherId);
        return map.get(dictCode);
    }

    @Override
    public Map<String, String> getDictionaryMapByFatherId(Long fatherId) {
        String jsonStr = (String) redisTemplate.opsForHash().get(RedisKeyEnum.CORE_DICT_ID_GET_CHILD_DICT_INFO_MAP_JSON_MAP.getRedisKey(), String.valueOf(fatherId));
        return Objects.requireNonNull(JSON.parseObject(jsonStr)).entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                res -> String.valueOf(res.getValue())
        ));
    }

    @Override
    public Long getIdByDictCode(String dictCode) {
        String str = (String) redisTemplate.opsForHash().get(RedisKeyEnum.CORE_DICT_DICT_CODE_GET_FATHER_ID_MAP_HASH.getRedisKey(), dictCode);
        assert str != null;
        return Long.parseLong(str);
    }


}




