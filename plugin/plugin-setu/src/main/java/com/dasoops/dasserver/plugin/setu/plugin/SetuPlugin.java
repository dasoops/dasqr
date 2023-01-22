package com.dasoops.dasserver.plugin.setu.plugin;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.setu.SetuTemplate;
import com.dasoops.dasserver.plugin.setu.cache.SetuCache;
import com.dasoops.dasserver.plugin.setu.entity.dto.SetuInfoDto;
import com.dasoops.dasserver.plugin.setu.entity.enums.SetuConfigRedisHashKeyEnum;
import com.dasoops.dasserver.plugin.setu.entity.enums.SetuSizeEnum;
import com.dasoops.dasserver.plugin.setu.entity.param.SetuParam;
import com.dasoops.minio.MinioTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: SetuPlugin
 * @ClassPath com.dasoops.dasserver.plugin.setu.plugin.SetuPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/22
 * @Version 1.0.0
 * @Description: setu插件
 * @see CqPlugin
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class SetuPlugin extends CqPlugin {

    private final SetuTemplate setuTemplate;
    private final MinioTemplate minioTemplate;
    private final ConfigCache configCache;
    private final SetuCache setuCache;

    final List<String> noParamEqualStringList = List.of("来点涩图", "setu", "getSetu");
    final String hasParamPrefix = "来点";
    final String hasParamSuffix = "涩图";
    final String pixivArtWorksUrl = "https://www.pixiv.net/artworks/";

    @MessageMapping(matchAll = true, type = MessageMappingTypeEnum.GROUP)
    public boolean getSetu(CqTemplate cqTemplate, MessageParam<SimpleParam> param) {

        String message = param.getRawMessage();

        boolean noTags = noParamEqualStringList.stream().noneMatch(message::equalsIgnoreCase);
        SetuParam setuParam = new SetuParam();
        //有tag
        if (noTags) {
            //非涩图短路放行
            if (!message.startsWith(hasParamPrefix) || !message.endsWith(hasParamSuffix)) {
                return true;
            }

            //提取tag
            String tagListStr = StrUtil.removePrefix(message, hasParamPrefix);
            tagListStr = StrUtil.removeSuffix(tagListStr, hasParamSuffix);
            List<String> tagList = StrUtil.split(tagListStr, ",");
            setuParam.setTag(tagList);

        }
        //通用参数
        setuParam.setR18(configCache.getIntegerConfig(SetuConfigRedisHashKeyEnum.DEFAULT_R18));
        setuParam.setProxy(configCache.getStringConfig(SetuConfigRedisHashKeyEnum.IMAGE_PROXY_BASE_URL));
        setuParam.setExcludeAI(configCache.getBooleanConfig(SetuConfigRedisHashKeyEnum.EXCLUDED_AI));
        setuParam.setSize(List.of(SetuSizeEnum.ORIGINAL.getApiValue(), SetuSizeEnum.REGULAR.getApiValue()));

        //发送
        SetuInfoDto setuInfo = setuTemplate.getSetuInfo(setuParam);
        cqTemplate.sendMsg(param, StrUtil.format("""
                        [{}]: {}
                        tags: {}
                        画廊url: {}
                        图片绝赞下载中...
                        """,
                setuInfo.getAuthor(), setuInfo.getTitle(),
                StrUtil.join(",", setuInfo.getTags()),
                pixivArtWorksUrl + setuInfo.getPid()
        ));
        log.info(JSON.toJSONString(setuInfo));

        //试图发送图片
        try {
            cqTemplate.sendMsg(param, CqCodeUtil.image(setuInfo.getUrls().getRegular()));
        } catch (LogicException e) {
            if (e.getExceptionEnum().equals(CqExceptionEnum.RESPONSE_ERROR)) {
                log.error("图片发送失败, 将通过私聊发送");
                String fileName = minioTemplate.saveImage(setuInfo.getUrls().getOriginal());
                String imagePath = minioTemplate.buildImagePath(fileName);
                cqTemplate.sendMsg(param, StrUtil.format("""
                        群聊图片发送失败, 腾讯色情管家鉴定为: 一伯分!
                        可以通过链接查看图片喵
                        {}
                        """, imagePath));
//                cqTemplate.sendPrivateMsg(param.getGroupId(), param.getUserId(), CqCodeUtil.image(setuInfo.getUrls().getRegular()));
            }
        }
        return false;
    }

}
