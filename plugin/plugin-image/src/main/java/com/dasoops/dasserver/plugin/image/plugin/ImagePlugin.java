package com.dasoops.dasserver.plugin.image.plugin;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.result.Result;
import com.dasoops.common.exception.LogicException;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqPrivateMessageEvent;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.cq.utils.DqCodeUtil;
import com.dasoops.dasserver.plugin.image.cache.ImageCache;
import com.dasoops.dasserver.plugin.image.entity.enums.ImageExceptionEnum;
import com.dasoops.dasserver.plugin.image.service.ImageService;
import com.dasoops.ocr.OcrTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title TemplatePlugin
 * @classPath com.dasoops.dasserver.plugin.image.plugin.TemplatePlugin
 * @date 2022/11/07
 * @description 图片插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class ImagePlugin extends CqPlugin {


    private final String FLAG = "flag";

    private final ImageService imageService;
    private final OcrTemplate ocrTemplate;
    private final ImageCache imageCache;

    public ImagePlugin(ImageService imageService, OcrTemplate ocrTemplate, ImageCache imageCache) {
        this.imageService = imageService;
        this.ocrTemplate = ocrTemplate;
        this.imageCache = imageCache;
    }

    @Override
    public PassObj onPrivateMessage(CqTemplate cqTemplate, CqPrivateMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        return onMessage(cqTemplate, event);
    }

    /**
     * 处理消息
     *
     * @param cqTemplate cqTemplate
     * @param cqMessageEvent 事件
     * @return {@link PassObj}
     */
    private PassObj onMessage(CqTemplate cqTemplate, CqMessageEvent cqMessageEvent) {
        String message = cqMessageEvent.getMessage();
        final String getImagePrefix = "取图 ";
        final String getImageSuffix = ".jpg";
        final String saveImagePrefix = "存图 ";

        if (StrUtil.startWithIgnoreCase(message, getImagePrefix)) {
            //取图逻辑
            log.debug("(ImagePlugin) 进入取图逻辑");

            List<String> paramStrList = DqCodeUtil.getParamStr(message, getImagePrefix);
            cqTemplate.sendMsg(cqMessageEvent, getImage(paramStrList));

            return PassObj.block();
        } else if (StrUtil.endWithIgnoreCase(message, getImageSuffix)) {
            //取图逻辑
            log.debug("(ImagePlugin) 进入取图逻辑");

            cqTemplate.sendMsg(cqMessageEvent, getImage(message.substring(0, message.length() - 4)));

            return PassObj.block();

        } else if (StrUtil.startWithIgnoreCase(message, saveImagePrefix)) {
            //存图逻辑
            log.debug("(ImagePlugin) 进入存图逻辑");

            List<String> paramStrList = DqCodeUtil.getParamStr(message, saveImagePrefix);
            cqTemplate.sendMsg(cqMessageEvent, saveImage(cqMessageEvent, paramStrList));

            return PassObj.block();
        } else {
            //分片存图 part.2 逻辑
            String key;
            if (cqMessageEvent instanceof CqGroupMessageEvent event) {
                //群组分片
                key = imageCache.hgetAndDeleteImagePartSaveFlag(event.getGroupId(), event.getUserId());
                if (key == null) {
                    return PassObj.pass(cqMessageEvent);
                }
            } else {
                //单人分片
                key = imageCache.getAndDeleteImagePartSaveFlag(cqMessageEvent.getUserId());
                if (key == null) {
                    return PassObj.pass(cqMessageEvent);
                }
            }
            log.debug("(ImagePlugin) 进入存图逻辑 - 分片逻辑");
            cqTemplate.sendMsg(cqMessageEvent, part2SaveImage(cqMessageEvent, key, DqCodeUtil.getParamStr(message, "").get(0)));
            return PassObj.block();
        }

    }

    /**
     * 获取图像
     *
     * @param paramStrList paramStr集合
     * @return {@link String}
     */
    private String getImage(List<String> paramStrList) {
        //为 0 异常
        if (paramStrList.size() <= 0) {
            return "你会取个der";
        }
        String keyword = paramStrList.get(0);

        return getImage(keyword);
    }

    /**
     * 获取图像
     *
     * @param keyword 关键字
     * @return {@link String}
     */
    private String getImage(String keyword) {

        Optional<String> imageCqCodeOpt = imageService.getImageCqCode(keyword);
        if (imageCqCodeOpt.isPresent()) {
            log.debug("(ImagePlugin) 取图逻辑执行完毕 - 有图分支");
            return imageCqCodeOpt.get();
        }

        StringBuilder sb = new StringBuilder("没有这张图捏");

        List<String> fantasyKeywordList = imageService.getFantasyKeyword4Cache(keyword);
        if (fantasyKeywordList != null && fantasyKeywordList.size() > 0) {
            sb.append(",相关关键词有: ");
            fantasyKeywordList.forEach(sb::append);
        }
        log.debug("(ImagePlugin) 取图逻辑执行完毕 - 无图分支");
        return sb.toString();

    }

    /**
     * 保存图像
     *
     * @param paramStrList param str列表
     * @return {@link String}
     */
    private String saveImage(CqMessageEvent event, List<String> paramStrList) {
        final int two = 2;
        if (paramStrList.size() == 0) {
            //分片存图 + OCR 逻辑 (存图 / image)
            return ocrPartSaveImage(event);
        } else if (paramStrList.size() == two) {
            //单片存图逻辑 (存图 keyword,image)
            return normalSaveImage(event, paramStrList.get(0), paramStrList.get(1));
        } else if (paramStrList.size() == 1) {
            String param = paramStrList.get(0);
            if (CqCodeUtil.haveCqCode(param)) {
                //单片OCR逻辑 (存图 image)
                return ocrSaveImage(event, param);
            } else {
                //分片逻辑 (存图 keyword,image)
                return partSaveImage(event, param);
            }
        } else {
            return "你会存个der";
        }
    }

    /**
     * 分片存图 + 预输入关键词逻辑 (存图 keyword / image)
     *
     * @return {@link String}
     */
    private String partSaveImage(CqMessageEvent cqMessageEvent, String key) {
        if (imageService.keywordIsRepeat(key)) {
            log.debug("(ImagePlugin) 存图逻辑执行完毕 - 分片存图+ 预输入关键词分支 part1 关键词重复");
            return "关键词有了捏";
        }
        if (cqMessageEvent instanceof CqGroupMessageEvent event) {
            imageCache.setGroupImagePartSave(event.getGroupId(), event.getUserId(), key);
        }
        imageCache.setUserImagePartSave(cqMessageEvent.getUserId(), key);
        log.debug("(ImagePlugin) 存图逻辑执行完毕 - 分片存图 + 预输入关键词分支 part1");
        return "图来";
    }

    /**
     * 分片存图逻辑 part2
     *
     * @return {@link String}
     */
    private String part2SaveImage(CqMessageEvent event, String key, String imgCqCode) {
        String url = CqCodeUtil.getImgUrl(imgCqCode);
        if (FLAG.equals(key)) {
            //ocr分支
            Result<String> result = ocrTemplate.forTencent(url);
            if (!result.getCode().equals(200)) {
                return "存图失败,ocr识别服务异常: " + result.getMsg();
            }
            key = result.getData();
            if (imageService.keywordIsRepeat(key)) {
                log.debug("(ImagePlugin) 存图逻辑执行完毕 - 分片存图 + ocr 分支 part2 关键词重复");
                return "这张图的关键词重复了捏";
            }

            imageService.saveImage(event, key, url);
            imageCache.removeImagePartSaveFlag(event);
            log.debug("(ImagePlugin) 存图逻辑执行完毕 - 分片存图 + ocr 分支 part2");
            return "好了捏,现在可以用 " + key + " 取出这张图辽";
        }

        //普通分片分支
        if (imageService.keywordIsRepeat(key)) {
            log.debug("(ImagePlugin) 存图逻辑执行完毕 - 分片存图 分支 part2 关键词重复");
            return "关键词有了捏";
        }
        imageService.saveImage(event, key, url);
        log.debug("(ImagePlugin) 存图逻辑执行完毕 - 分片存图 分支 part2");
        return "已阅";
    }

    /**
     * 单片存图逻辑 (存图 keyword,image)
     *
     * @return {@link String}
     */
    private String normalSaveImage(CqMessageEvent event, String keyword, String imgCqCode) {
        if (imageService.keywordIsRepeat(keyword)) {
            log.debug("(ImagePlugin) 存图逻辑执行完毕 - 单片存图分支 关键词重复");
            return "关键词有了捏";
        }
        imageService.saveImage(event, keyword, CqCodeUtil.getImgUrl(imgCqCode));
        imageCache.removeImagePartSaveFlag(event);
        log.debug("(ImagePlugin) 存图逻辑执行完毕 - 单片存图分支");
        return "已阅";
    }

    /**
     * 单片存图 + OCR逻辑 (存图 image)
     *
     * @return {@link String}
     */
    private String ocrSaveImage(CqMessageEvent event, String imgCqCode) {
        //获取url
        String url = CqCodeUtil.getImgUrl(imgCqCode);

        //调用ocr
        Result<String> result = ocrTemplate.forTencent(url);
        if (!result.getCode().equals(200)) {
            return "存图失败,ocr识别服务异常: " + result.getMsg();
        }

        //获取识别关键词
        String keyword = result.getData();

        if (imageService.keywordIsRepeat(keyword)) {
            log.debug("(ImagePlugin) 存图逻辑执行完毕 - ocr分支 关键词重复");
            return "这张图的关键词重复了捏";
        }
        //持久化
        imageService.saveImage(event, keyword, url);
        imageCache.removeImagePartSaveFlag(event);

        log.debug("(ImagePlugin) 存图逻辑执行完毕 - ocr分支");
        return "好了捏,现在可以用 " + result.getData() + " 取出这张图辽";
    }

    /**
     * 分片存图 + OCR 逻辑 (存图 / image) part1
     *
     * @return {@link String}
     */
    private String ocrPartSaveImage(CqMessageEvent cqMessageEvent) {
        imageCache.setImagePartSaveAndExpire(cqMessageEvent, FLAG, 1L, TimeUnit.MINUTES);
        log.debug("(ImagePlugin) 存图逻辑执行完毕 - 分片存图 + OCR 分支 part1");
        return "图来";
    }

    private void saveImage2Db(CqMessageEvent event, String url, String keyword) {
        boolean saveImage;
        if (event instanceof CqGroupMessageEvent) {
            saveImage = imageService.saveImage(((CqGroupMessageEvent) event).getGroupId(), event.getUserId(), keyword, url);
        } else {
            saveImage = imageService.saveImage(event.getUserId(), keyword, url);
        }
        if (!saveImage) {
            throw new LogicException(ImageExceptionEnum.IMAGE_SAVE_ERROR);
        }
    }

}