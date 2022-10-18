package com.dasoops.dasq.core.common.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.RedisKeyEnum;
import com.dasoops.dasq.core.common.entity.po.Dictionary;
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
    public void initOrUpdate() {
        initOrUpdateDictTreeData2Redis();
        initOrUpdateDictFatherDictCodeMap2Redis();
    }

    @Override
    public void init() {
        initVersion2Redis();
        this.initOrUpdate();
    }

    private void initVersion2Redis() {
        log.info("初始化 Version 数据至redis");

        redisTemplate.delete(RedisKeyEnum.VERSION.getRedisKey());

        Dictionary dict = super.lambdaQuery().eq(Dictionary::getDictCode, "version").one();
        String version = dict.getDictValue();

        redisTemplate.opsForValue().set(RedisKeyEnum.VERSION.getRedisKey(), version);

        log.info("完成: 初始化 Version 数据至redis,Data:{}", JSON.toJSONString(version));
    }

    private void initOrUpdateDictTreeData2Redis() {
        log.info("初始化/更新 DictionaryTreeData 数据至redis");

        //清除旧数据
        redisTemplate.delete(RedisKeyEnum.DICT_DICT_CODE_GET_FATHER_ID_HASH.getRedisKey());

        //查询数据库,构建集合
        List<Dictionary> list = super.lambdaQuery().eq(Dictionary::getParentId, -1).list();
        Map<String, String> map = list.stream().collect(Collectors.toMap(Dictionary::getDictCode, res -> String.valueOf(res.getId())));

        //存入
        redisTemplate.opsForHash().putAll(RedisKeyEnum.DICT_DICT_CODE_GET_FATHER_ID_HASH.getRedisKey(), map);

        log.info("完成: 初始化/更新 DictionaryTreeData 数据至redis,Data:{}", JSON.toJSONString(map));
    }

    @SuppressWarnings("unchecked")
    private void initOrUpdateDictFatherDictCodeMap2Redis() {
        log.info("初始化/更新 DictFatherDictCodeMap 数据至redis");

        //清除旧数据
        redisTemplate.delete(RedisKeyEnum.DICT_ID_GET_CHILD_DICT_INFO_MAP_JSON_MAP.getRedisKey());

        //查询数据库,构建集合
        List<Dictionary> list = super.lambdaQuery().list();
        Map<Long, Object> map = new HashMap<>(16);
        list.forEach(res -> {
            //parentId = -1 && hasChild 1 为集合
            //parentId = -1 && hasChild 0 为单项
            //parentId != -1              为子项
            Long parentId = res.getParentId();
            if (parentId == -1 && res.getHasChild() == 1) {
                map.put(res.getId(), new HashMap<String, String>(16));
            } else if (parentId != -1) {
                Map<String, String> getMap;
                getMap = (Map<String, String>) map.get(res.getParentId());
                getMap.put(res.getDictCode(), res.getDictValue());
            } else {
                map.put(res.getId(), res.getDictValue());
            }
        });
        Map<String, String> resMap = map.entrySet().stream().collect(Collectors.toMap(
                res -> String.valueOf(res.getKey()),
                res -> {
                    if (res.getValue() instanceof String) {
                        return String.valueOf(res.getValue());
                    }
                    return JSON.toJSONString(res.getValue());
                }
        ));

        //存入
        redisTemplate.opsForHash().putAll(RedisKeyEnum.DICT_ID_GET_CHILD_DICT_INFO_MAP_JSON_MAP.getRedisKey(), resMap);

        log.info("完成: 初始化/更新 DictFatherDictCodeMap 数据至redis,Data:{}", JSON.toJSONString(map));
    }

    @Override
    public String getDictionaryById(Long fatherId, String dictCode) {
        Map<String, String> map = getDictionaryMapByFatherId(fatherId);
        return map.get(dictCode);
    }

    @Override
    public Map<String, String> getDictionaryMapByFatherId(Long fatherId) {
        String jsonStr = (String) redisTemplate.opsForHash().get(RedisKeyEnum.DICT_ID_GET_CHILD_DICT_INFO_MAP_JSON_MAP.getRedisKey(), String.valueOf(fatherId));
        return Objects.requireNonNull(JSON.parseObject(jsonStr)).entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                res -> String.valueOf(res.getValue())
        ));
    }

    @Override
    public Map<String, String> getDictionaryMapByDictCode(String dictCode) {
        return getDictionaryMapByFatherId(getIdByDictCode(dictCode));
    }

    @Override
    public String getDictValueByDictCode(String dictCode) {
        return String.valueOf(redisTemplate.opsForHash().get(RedisKeyEnum.DICT_ID_GET_CHILD_DICT_INFO_MAP_JSON_MAP.getRedisKey(), String.valueOf(getIdByDictCode(dictCode))));
    }

    @Override
    public Long getIdByDictCode(String dictCode) {
        String str = (String) redisTemplate.opsForHash().get(RedisKeyEnum.DICT_DICT_CODE_GET_FATHER_ID_HASH.getRedisKey(), dictCode);
        assert str != null;
        return Long.parseLong(str);
    }

    @Override
    public synchronized void updateVersion(Integer commitCount) {
        final int maxLength = 3;
        Dictionary dict = super.getById(11L);
        int version = Integer.parseInt(dict.getDictValue());
        String versionStr = String.valueOf(version + commitCount);
        if (versionStr.length() < maxLength) {
            versionStr = "0".repeat(3 - versionStr.length()) + versionStr;
        }
        dict.setDictValue(versionStr);
        super.updateById(dict);
    }

    @Override
    public String getVersion() {
        return redisTemplate.opsForValue().get(RedisKeyEnum.VERSION.getRedisKey());
    }

    @Override
    public String getCloudVersion() {
        return super.lambdaQuery().eq(Dictionary::getDictCode, "version").one().getDictValue();
    }

}




