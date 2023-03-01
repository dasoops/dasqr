package com.dasoops.dasserver.plugin.loaj.plugin;

import com.dasoops.common.entity.enums.base.DbBooleanEnum;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.utils.CqMessageAssert;
import com.dasoops.dasserver.plugin.loaj.cache.ReplyCache;
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ReplyRedisValueDto;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyIgnoreCaseEnum;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyIgnoreDbcEnum;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyMatchTypeEnum;
import com.dasoops.dasserver.plugin.loaj.entity.param.AddReplyParam;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
import com.dasoops.dasserver.plugin.loaj.service.impl.ReplySimpleSql;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title AddRelayPlugin
 * @classPath com.dasoops.dasserver.plugin.loaj.plugin.AddRelayPlugin
 * @date 2022/11/11
 * @description 添加回复插件
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class AddReplyPlugin extends CqPlugin {


    private final ReplyService replyService;
    private final ReplySimpleSql replySimpleSql;
    private final ReplyCache replyCache;


    @MessageMapping(prefix = {"addReply", "跟我学"}, type = MessageMappingTypeEnum.ALL)
    public String addReply(MessageParam<AddReplyParam> message) {
        CqMessageAssert.getInstance().allMustNotNull(message, message.getParam(), message.getParam().getReply(), message.getParam().getKeyword());

        AddReplyParam param = message.getParam();
        ReplyDo replyDo = new ReplyDo();
        replyDo.setKeyword(param.getKeyword());
        replyDo.setReply(param.getReply());
        replyDo.setEnable(DbBooleanEnum.TRUE.getDbValue());
        replyDo.setIgnoreCase(ReplyIgnoreCaseEnum.TRUE.getDbValue());
        replyDo.setIgnoreDbc(ReplyIgnoreDbcEnum.TRUE.getDbValue());
        replyDo.setMatchType(ReplyMatchTypeEnum.ALL.getDbValue());
        replySimpleSql.save(replyDo);

        ReplyRedisValueDto replyDto = new ReplyRedisValueDto();
        replyDto.setKeyword(param.getKeyword());
        replyDto.setReply(param.getReply());
        replyDto.setIgnoreCase(true);
        replyDto.setIgnoreDbc(true);
        replyDto.setMatchType(ReplyMatchTypeEnum.ALL.getDbValue());
        replyCache.addreply(replyDto);
        return "已阅";
    }

}
