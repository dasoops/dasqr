package com.dasoops.dasserver.plugin.recall.plugin

import cn.hutool.core.date.DateUtil
import com.dasoops.common.entity.param.SimpleParam
import com.dasoops.dasserver.cq.CqPlugin
import com.dasoops.dasserver.cq.cache.RegisterCache
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum
import com.dasoops.dasserver.plugin.log.entity.dbo.MessageDo
import com.dasoops.dasserver.plugin.recall.cache.RecallCache
import lombok.extern.slf4j.Slf4j
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
@Slf4j
class RecallPlugin(
    private val mongoTemplate: MongoTemplate,
    private val recallCache: RecallCache,
    private val registerCache: RegisterCache,
) : CqPlugin() {

    override fun getRawPlugin(): CqPlugin {
        return this;
    }

    @MessageMapping(equal = ["recall", "看看丢人"], type = MessageMappingTypeEnum.GROUP)
    fun undo(messageParam: MessageParam<SimpleParam>): String? {
        val messageId = recallCache.get(messageParam.groupId) ?: return null;
        val messageDoList =
            mongoTemplate.find(Query.query(Criteria.where("messageId").`is`(messageId)), MessageDo::class.java)
                ?: return "没有撤回记录捏";
        val messageDo: MessageDo = messageDoList[0];
        val registerName = registerCache.getRegisterNameById(messageDo.userId);

        return """
            $registerName(${DateUtil.date(messageDo.time * 1000)}):
            ${messageDo.message}
        """.trimIndent();
    }
}