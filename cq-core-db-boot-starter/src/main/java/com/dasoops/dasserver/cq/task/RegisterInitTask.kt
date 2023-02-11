package com.dasoops.dasserver.cq.task

import com.dasoops.common.task.BaseTask
import com.dasoops.dasserver.cq.CqTemplate
import com.dasoops.dasserver.cq.service.RegisterService
import org.springframework.stereotype.Component

@Component
class RegisterInitTask(private val registerService: RegisterService) : BaseTask() {

    /**
     * 初始化或更新所有
     * @param [cqTemplate] cq模板
     */
    fun initOrUpdateAll(cqTemplate: CqTemplate?) {
        registerService.initOrUpdateRegisterRowIdOtoTypeMap2Cache()
        registerService.initOrUpdateRegisterTypeRegisterIdOtoId2Cache()
        registerService.initOrUpdateRegisterRowIdOtoNameMapAndRegisterUserIdOtoNameMap2Cache(cqTemplate)
    }

}