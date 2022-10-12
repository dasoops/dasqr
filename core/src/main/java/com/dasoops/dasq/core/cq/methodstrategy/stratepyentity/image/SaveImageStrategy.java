package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.image;

import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.common.util.RegexUtil;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
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
}
