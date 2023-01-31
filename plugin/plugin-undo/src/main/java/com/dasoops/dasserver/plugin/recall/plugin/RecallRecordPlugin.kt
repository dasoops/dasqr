package com.dasoops.dasserver.plugin.recall.plugin

import com.dasoops.dasserver.cq.CqPlugin
import com.dasoops.dasserver.cq.CqTemplate
import com.dasoops.dasserver.cq.PassObj
import com.dasoops.dasserver.cq.entity.dto.cq.event.notice.CqGroupRecallNoticeEvent
import com.dasoops.dasserver.plugin.recall.cache.RecallCache
import org.springframework.stereotype.Component

@Component
class RecallRecordPlugin(private val recallCache: RecallCache) : CqPlugin() {
    override fun onGroupRecallNotice(cqTemplate: CqTemplate, event: CqGroupRecallNoticeEvent): PassObj {
        recallCache.set(event.groupId, event.messageId);
        return PassObj.pass(event);
    }
}