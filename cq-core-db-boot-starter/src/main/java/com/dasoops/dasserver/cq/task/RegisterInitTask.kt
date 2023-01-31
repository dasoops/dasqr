package com.dasoops.dasserver.cq.task

import com.dasoops.common.task.BaseInitTask
import com.dasoops.dasserver.cq.CqTemplate
import com.dasoops.dasserver.cq.service.RegisterService
import org.springframework.stereotype.Component

@Component
class RegisterInitTask(private val registerService: RegisterService) : BaseInitTask() {

    /**
     * 初始化或更新所有
     * @param [cqTemplate] cq模板
     */
    fun initOrUpdateAll(cqTemplate: CqTemplate?) {
        initOrUpdateRegisterIdOtoNameMap2Cache(cqTemplate)
    }

    /**
     * 初始化或更新注册表id单对单名字map to 缓存
     * @param [cqTemplate] cqTemplate
     */
    private fun initOrUpdateRegisterIdOtoNameMap2Cache(cqTemplate: CqTemplate?) {
        registerService.initOrUpdateRegisterRowIdOtoNameMapAndRegisterUserIdOtoNameMap2Cache(cqTemplate)
    }

}