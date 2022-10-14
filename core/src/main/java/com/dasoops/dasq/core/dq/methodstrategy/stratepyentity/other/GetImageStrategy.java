package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other;

import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import com.dasoops.dasq.core.image.service.ImageInfoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Title: GetImageStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.image.GetImageStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/11
 * @Version 1.0.0
 * @Description: 得到图像策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
public class GetImageStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {
    @Resource
    private ImageInfoService imageInfoService;

    @Override
    public Long getId() {
        return 1579757938784059393L;
    }

    @Override
    public void invoke(List<String> params) {
        String keyword = params.get(0);
        Optional<String> imageCqCodeOpt = imageInfoService.getImageCqCode(keyword);
        if (imageCqCodeOpt.isPresent()) {
            cqService.sendMsg(imageCqCodeOpt.get());
            return;
        }
        StringBuilder sb = new StringBuilder("没有这张图捏");
        List<String> keywordList = imageInfoService.getImageKeywordList();

        AtomicBoolean isFirst = new AtomicBoolean(true);
        keywordList.stream().filter(res -> res.contains(keyword)).forEach(res -> {
            if (!isFirst.get()) {
                sb.append(",").append(res);
            } else {
                sb.append(",相关关键词有: ");
                sb.append(res);
                isFirst.set(false);
            }
        });
        cqService.sendMsg(sb.toString());
    }
}
