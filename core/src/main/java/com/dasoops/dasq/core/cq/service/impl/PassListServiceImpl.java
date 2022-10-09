package com.dasoops.dasq.core.cq.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasq.core.cq.entity.enums.CqRedisKeyEnum;
import com.dasoops.dasq.core.cq.service.PassListService;
import com.dasoops.dasq.core.cq.entity.pojo.PassObject;
import com.dasoops.dasq.core.cq.mapper.PassListMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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

    @Override
    public void initOrUpdatePassListJsonSet2Redis() {
        log.info("初始化/更新 PassListJsonSet 数据至redis");

        //清除旧数据
        redisTemplate.delete(CqRedisKeyEnum.PASS_LIST_JSON_SET.getRedisKey());

        //查询数据库,构建集合
        List<PassObject> list = super.lambdaQuery().list();

        String jsonStr = JSON.toJSONString(list);

        String[] strArr = new String[list.size()];
        strArr = list.stream().map(JSON::toJSONString).collect(Collectors.toList()).toArray(strArr);

        //存入
        redisTemplate.opsForSet().add(CqRedisKeyEnum.PASS_LIST_JSON_SET.getRedisKey(), strArr);

        log.info("完成: 初始化/更新 PassListJsonSet 数据至redis,Data:{}", jsonStr);
    }
}