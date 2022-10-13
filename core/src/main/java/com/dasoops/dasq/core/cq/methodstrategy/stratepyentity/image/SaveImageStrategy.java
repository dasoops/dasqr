package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.image;

import com.dasoops.common.entity.enums.RedisKeyEnum;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.common.util.RegexUtil;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import com.dasoops.dasq.core.image.entity.enums.ImageRedisKeyEnum;
import com.dasoops.dasq.core.image.service.ImageInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: SaveImageStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.image.SaveImageStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/11
 * @Version 1.0.0
 * @Description: 保存图片策略
 * @see BaseCqMethodStrategy
 */
@Component
public class SaveImageStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource
    private ImageInfoService imageInfoService;

    @Override
    public Long getId() {
        return 1579691187203469314L;
    }

    @Override
    public void invoke(List<String> params) {
        //手机兼容 分段发送
        if (params.get(1) == null) {
            //判断是否重复
            if (imageInfoService.keywordIsRepeat(params.get(0))) {
                cqService.sendMsg("关键词已存在");
                return;
            }
            redisTemplate.opsForValue().set(ImageRedisKeyEnum.SAVE_IMAGE_PART.getRedisKey(), params.get(0));
            cqService.sendMsg("图来");
            return;
        }
        //非手机兼容直接存图
        saveImage(params);
    }

    /**
     * 保存图像
     *
     * @param params 参数
     */
    public void saveImage(List<String> params) {
        EventInfo eventInfo = EventUtil.get();
        //正则匹配参数
        Optional<String> matchStr = RegexUtil.getMatchStr(".(?<=url=h).*?(?=])", params.get(1));
        boolean isRepeat = imageInfoService.saveImage(eventInfo.getGroupId(), eventInfo.getAuthorId(), null, params.get(0), params.get(2),
                matchStr.orElseThrow(() -> new LogicException(ExceptionCodeEnum.IMAGE_GET_ERROR)));

        if (!isRepeat) {
            cqService.sendMsg("关键词已存在");
        }

        cqService.sendMsg("已阅");
    }


    /**
     * 保存图像
     *
     * @param keyword 关键字
     * @param cqCode  cq编号
     */
    public void saveImage(String keyword, String cqCode) {
        EventInfo eventInfo = EventUtil.get();
        //正则匹配参数
        Optional<String> matchStr = RegexUtil.getMatchStr(".(?<=url=h).*?(?=])", cqCode);
        if (matchStr.isEmpty()) {
            cqService.sendMsg("存图失败,你会不会啊~");
            return;
        }

        imageInfoService.saveImage(eventInfo.getGroupId(), eventInfo.getAuthorId(), null, keyword, null,
                matchStr.get());

        cqService.sendMsg("已阅");
    }
}
