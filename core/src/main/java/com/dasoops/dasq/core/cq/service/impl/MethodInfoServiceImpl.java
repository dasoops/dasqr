package com.dasoops.dasq.core.cq.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.cq.entity.bo.HelpBo;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.entity.enums.CqRedisKeyEnum;
import com.dasoops.dasq.core.cq.entity.po.MethodInfo;
import com.dasoops.dasq.core.cq.entity.po.MethodType;
import com.dasoops.dasq.core.cq.entity.po.PassObject;
import com.dasoops.dasq.core.cq.service.MethodInfoService;
import com.dasoops.dasq.core.cq.mapper.MethodInfoMapper;
import com.dasoops.dasq.core.cq.service.MethodTypeService;
import com.dasoops.dasq.core.cq.service.PassListService;
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
    @Resource
    private PassListService passListService;
    @Resource
    private MethodTypeService methodTypeService;
    @Resource
    private MethodInfoMapper methodInfoMapper;
    @Resource
    private DasqProperties dasqProperties;

    @Override
    public void initOrUpdate() {
        initOrUpdateMethodInfoIdEntityJson2Redis();
        initOrUpdateHelpDoc();
    }

    private void initOrUpdateMethodInfoIdEntityJson2Redis() {
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


    private void initOrUpdateHelpDoc() {
        log.info("初始化/更新 HelpDoc 数据至redis");
        List<HelpBo> boList = methodInfoMapper.selectHelpBoList();
        StringBuilder sb = new StringBuilder("帮助文档").append(" Ver.").append(dasqProperties.getVersion());
        boList.forEach(res -> sb.append(res.getKeyword()).append("   ").append(res.getDescription()).append("\r\n"));
        redisTemplate.opsForValue().set(CqRedisKeyEnum.HELP_DOC_STRING.getRedisKey(), sb.toString());
        log.info("完成: 初始化/更新 HelpDoc 数据至redis,Data:{}", sb);
    }

    @Override
    public MethodInfo getMethodInfoIdByKeyWord(String keyword) {
        String id = (String) redisTemplate.opsForHash().get(CqRedisKeyEnum.PASS_LIST_KEYWORD_GET_METHOD_INFO_ID_MAP.getRedisKey(), keyword);
        if (id == null) {
            return null;
        }
        String jsonStr = (String) redisTemplate.opsForHash().get(CqRedisKeyEnum.METHOD_INFO_ID_GET_ENTITY_JSON_MAP.getRedisKey(), id);
        return JSON.parseObject(jsonStr, MethodInfo.class);
    }

    @Override
    public void addMethod(String keyword, String typeKeyword, String description, String parametersStr) {
        //获取methodType
        MethodType methodType = methodTypeService.lambdaQuery().eq(MethodType::getKeyword, typeKeyword.toLowerCase()).one();
        if (methodType == null) {
            throw new LogicException(ExceptionCodeEnum.PARAMETER_GET_ERROR);
        }

        //构建methodInfo,存入
        MethodInfo methodInfo = new MethodInfo();
        methodInfo.setEnable(1);
        methodInfo.setParameters(parametersStr);
        methodInfo.setTypeId(methodType.getId());
        methodInfo.setDescription(description);
        this.save(methodInfo);

        PassObject passObject = new PassObject();
        passObject.setEnable(Integer.parseInt(CqKeywordEnum.ENABLE.getOtherName()));
        passObject.setType(Integer.parseInt(CqKeywordEnum.MESSAGE_TYPE_MESSAGE_PREFIX.getOtherName()));
        passObject.setMethodInfoId(methodInfo.getId());
        passObject.setPassKeyword(StrUtil.removePrefix(keyword.toLowerCase(), CqKeywordEnum.COMMON_PREFIX.getSimpleName()));
        passListService.save(passObject);

        //更新数据
        initOrUpdate();
        passListService.initOrUpdate();
    }


    @Override
    public String getHelpDoc() {
        return redisTemplate.opsForValue().get(CqRedisKeyEnum.HELP_DOC_STRING.getRedisKey());
    }


}




