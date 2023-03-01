package com.dasoops.dasserver.plugin.randomreply.plugin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.PassObj;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.cache.RegisterCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqMessageEvent;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.result.PluginResult;
import com.dasoops.dasserver.plugin.log.entity.dbo.MessageDo;
import com.mongodb.DBObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title RandomReplyPlugin
 * @classPath com.dasoops.dasserver.plugin.randomreply.plugin.RandomReplyPlugin
 * @date 2023/03/01
 * @description 随机回复插件
 * @see CqPlugin
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class RandomReplyPlugin extends CqPlugin {

    private final RandomReplyCache randomReplyCache;
    private final ConfigCache configCache;
    private final MongoTemplate mongoTemplate;

    @Override
    public CqPlugin getRawPlugin() {
        return this;
    }

    @Override
    public PassObj onGroupMessage(CqTemplate cqTemplate, CqGroupMessageEvent event) {
        log.debug("随机回复逻辑");
        int randomInt = RandomUtil.randomInt(0, configCache.getIntegerConfig(RandomReplyConfigKey.RANDOM_FREQUENCY));
        if (randomInt == 1) {
            int count = (int) mongoTemplate.count(new Query(), MessageDo.class);
            MessageDo messageDo = mongoTemplate.findOne(new Query().skip(RandomUtil.randomInt(1, count - 1)), MessageDo.class);
            randomReplyCache.setLastInfo(messageDo);
            cqTemplate.sendMsg(event, messageDo.getMessage());
            return PassObj.block();
        }
        return PassObj.pass(event);
    }

}
