package com.dasoops.dasserver.plugin.randomreply.plugin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.cache.RegisterCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
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
    private final RegisterCache registerCache;

    @Override
    public CqPlugin getRawPlugin() {
        return this;
    }

    @MessageMapping(matchAll = true, type = MessageMappingTypeEnum.GROUP)
    public String randomReply() {
        int randomInt = RandomUtil.randomInt(0, configCache.getIntegerConfig(RandomReplyConfigKey.RANDOM_FREQUENCY));
        if (randomInt == 1) {
            int count = (int) mongoTemplate.count(new Query(), MessageDo.class);
            MessageDo messageDo = mongoTemplate.findOne(new Query().skip(RandomUtil.randomInt(1, count - 1)), MessageDo.class);
            randomReplyCache.setLastInfo(messageDo);
            return messageDo.getMessage();
        }
        return null;
    }

    @MessageMapping(equal = "谁发的", type = MessageMappingTypeEnum.GROUP)
    public String genInfo() {
        MessageDo lastInfo = randomReplyCache.getLastInfo();
        String userName = registerCache.getRegisterUserNameById(lastInfo.getUserId());
        Query nextQuery = Query.query(Criteria.where("time").gt(lastInfo.getTime())).with(Sort.by("_id").ascending()).limit(1);
        MessageDo next = mongoTemplate.findOne(nextQuery, MessageDo.class);
        Query lastQuery = Query.query(Criteria.where("time").lt(lastInfo.getTime())).with(Sort.by("_id").descending()).limit(1);
        MessageDo last = mongoTemplate.findOne(lastQuery, MessageDo.class);
        String lastUserName = registerCache.getRegisterUserNameById(last.getUserId());
        String nextUserName = registerCache.getRegisterUserNameById(next.getUserId());

        return StrUtil.format("""
                        {} in {}
                        上一句是: {} -> {}
                        下一句是: {} -> {}
                        """,
                userName, DateUtil.date(lastInfo.getTime() * 1000),
                lastUserName, last.getMessage(),
                nextUserName, next.getMessage()
        );

    }

}
