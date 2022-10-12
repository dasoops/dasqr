package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.sys;//package com.dasoops.dasq.core.cq.methodstrategy.stratepyentity;

import com.dasoops.common.entity.enums.RedisKeyEnum;
import com.dasoops.dasq.core.common.entity.DasqProperties;
import com.dasoops.dasq.core.common.entity.enums.KeywordEnum;
import com.dasoops.dasq.core.common.util.KeywordUtil;
import com.dasoops.dasq.core.cq.methodstrategy.entity.enums.DqRedisKeyEnum;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: StyleStrategy
 * @ClassPath com.dasoops.dasq.core.cq.methodstrategy.stratepyentity.sys.StyleStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: 风格策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
public class StyleStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    @Resource(name = "stringRedisTemplate", type = StringRedisTemplate.class)
    private StringRedisTemplate redisTemplate;
    @Resource
    private DasqProperties dasqProperties;

    @Override
    public Long getId() {
        return 1580126446202589186L;
    }

    @Override
    public void invoke(List<String> params) {
        String style;
        if (params.isEmpty() || params.get(0) == null) {
            style = KeywordEnum.STYLE_NORMAL.getKeyword();
        } else {
            style = params.get(0);
        }
        if (KeywordUtil.isNormal(style) || KeywordUtil.isCool(style)) {
            redisTemplate.opsForValue().set(DqRedisKeyEnum.STYLE.getRedisKey(), style);
            cqService.sendMsg("命令模式设置为:" + (KeywordUtil.isCool(style) ? "极简模式" : "普通模式"));
            return;
        }
        cqService.sendMsg("暂时只支持 normal(普通模式)/cool(极简模式) 模式捏");
    }

    /**
     * 得到style
     *
     * @return {@link String}
     */
    public String getStyle() {
        return redisTemplate.opsForValue().get(DqRedisKeyEnum.STYLE.getRedisKey());
    }

    /**
     * 初始化指令风格
     */
    public void init() {
        redisTemplate.opsForValue().set(DqRedisKeyEnum.STYLE.getRedisKey(), dasqProperties.getStyle());
    }
}
