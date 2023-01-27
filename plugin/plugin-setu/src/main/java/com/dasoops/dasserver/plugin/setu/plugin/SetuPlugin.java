package com.dasoops.dasserver.plugin.setu.plugin;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.enums.base.IExceptionEnum;
import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.exception.CqLogicException;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.setu.SetuTemplate;
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
 * @ClassPath com.dasoops.dasserver.plugin.shell.plugin.SetuPlugin
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

    @Override
    public CqPlugin getRawPlugin() {
        return this;
    }


    private final SetuTemplate setuTemplate;
    private final MinioTemplate minioTemplate;
    private final ConfigCache configCache;

    final List<String> noParamEqualStringList = List.of("来点涩图", "setu", "getSetu");
    final String hasParamPrefix = "来点";
    final String hasParamSuffix = "涩图";

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
            tagListStr = Convert.toDBC(tagListStr);
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
        if (setuInfo == null) {
            cqTemplate.sendMsg(param, "没有包含这个tag的涩图哦");
            return false;
        }
        long pid = setuInfo.getPid();
        String pixivArtWorksUrl = configCache.getStringConfig(SetuConfigRedisHashKeyEnum.PIXIV_ART_WORKS_URL);
        String proxyArtWorksUrl = configCache.getStringConfig(SetuConfigRedisHashKeyEnum.PROXY_ART_WORKS_URL);
        cqTemplate.sendMsg(param, StrUtil.format("""
                        [{}]: {}
                        tags: {}
                        画廊url: {}
                        代理画廊url: {}
                        图片绝赞下载中...
                        """,
                setuInfo.getAuthor(), setuInfo.getTitle(),
                StrUtil.join(",", setuInfo.getTags()),
                pixivArtWorksUrl + pid,
                proxyArtWorksUrl + pid
        ));

        //试图发送图片
        try {
            cqTemplate.sendMsg(param, CqCodeUtil.image(setuInfo.getUrls().getRegular()));
        } catch (CqLogicException e) {
            IExceptionEnum exceptionEnum = e.getExceptionEnum();
            if (exceptionEnum.equals(CqExceptionEnum.SEND_ERROR) || exceptionEnum.equals(CqExceptionEnum.EMPTY_MSG)) {
                log.error("图片代理站404,可能是画廊更新");
                cqTemplate.sendMsg(param, StrUtil.format("""
                                发送失败,代理站未保留画廊更新记录,请前往pixiv画廊查看喵
                                pixiv   : {}
                                pixivel : {}
                                """,
                        pixivArtWorksUrl + pid,
                        proxyArtWorksUrl + pid
                ));
            } else if (exceptionEnum.equals(CqExceptionEnum.RESPONSE_ERROR)) {
                log.error("图片发送失败");
                String fileName = minioTemplate.saveImage(setuInfo.getUrls().getOriginal());
                String imagePath = minioTemplate.buildImagePath(fileName);
                cqTemplate.sendMsg(param, StrUtil.format("""
                        群聊图片发送失败, 腾讯色情管家鉴定为: 一伯分!
                        可以通过链接查看图片喵
                        {}
                        """, imagePath)
                );
            }
        }
        return false;
    }

}
