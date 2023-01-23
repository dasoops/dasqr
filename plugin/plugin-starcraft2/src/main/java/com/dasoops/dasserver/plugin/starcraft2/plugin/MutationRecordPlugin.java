package com.dasoops.dasserver.plugin.starcraft2.plugin;

import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.plugin.shammessage.ShamMessageTemplate;
import com.dasoops.dasserver.plugin.starcraft2.service.MutationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Title: StarCraftPlugin
 * @ClassPath com.dasoops.dasserver.plugin.starcraft2.plugin.StarCraftPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 星际插件
 * @see CqPlugin
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class MutationRecordPlugin extends CqPlugin {

    private final MutationService mutationService;
    private final ShamMessageTemplate shamMessageTemplate;

    /**
     * 突变记录数自增
     *
     * @param messageParam 消息param
     * @return {@link String}
     */
    @MessageMapping(equal = "incrementMutation", type = MessageMappingTypeEnum.ALL)
    public void incrementMutationRecord(MessageParam<BaseParam> messageParam, CqTemplate cqTemplate) {
        //记录数
        mutationService.incrementRecord();

        cqTemplate.sendMsg(messageParam, "已阅");
        shamMessageTemplate.sendMsg("下周突变");
    }

    /**
     * 突变记录数自增(静默,供定时任务使用)
     *
     * @param messageParam 消息param
     * @return {@link String}
     */
    @MessageMapping(equal = "quietIncrementMutation", type = MessageMappingTypeEnum.ALL)
    public void quietIncrementMutation(MessageParam<BaseParam> messageParam) {
        mutationService.incrementRecord();
    }

}
