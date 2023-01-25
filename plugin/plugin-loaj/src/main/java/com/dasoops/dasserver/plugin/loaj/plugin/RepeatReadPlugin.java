package com.dasoops.dasserver.plugin.loaj.plugin;

import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.CqGroupMessageEvent;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.plugin.loaj.cache.RepeatReadCache;
import com.dasoops.dasserver.plugin.loaj.entity.dto.RepeatReadRedisDto;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajConfigHashKeyEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Title: RepeatReadPlugin
 * @ClassPath com.dasoops.dasserver.plugin.loaj.plugin.RepeatReadPlugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/19
 * @Version 1.0.0
 * @Description: 复读插件
 */
@RequiredArgsConstructor
@Component
public class RepeatReadPlugin extends CqPlugin {

    private final RepeatReadCache repeatReadCache;
    private final ConfigCache configCache;

    @MessageMapping(type = MessageMappingTypeEnum.GROUP, matchAll = true)
    public boolean repeatRead(CqGroupMessageEvent event, CqTemplate cqTemplate) {
        String message = event.getMessage();
        long groupId = event.getGroupId();
        RepeatReadRedisDto dto = repeatReadCache.get(groupId);
        //无记录,初始化 || 消息不相同 覆盖,return
        if (dto == null || !dto.getMessage().equals(message)) {
            dto = new RepeatReadRedisDto();
            dto.setMessage(message);
            dto.setCount(1);
            repeatReadCache.put(groupId, dto);
            return true;
        }
        //消息相同,检查复读次数
        if (message.equals(dto.getMessage())) {
            Integer needCount = configCache.getIntegerConfig(LoajConfigHashKeyEnum.REPEAT_READ_COUNT);
            int count = dto.getCount() + 1;
            //大于复读
            if (count >= needCount) {
                dto.setCount(0);
                repeatReadCache.put(groupId, dto);
                cqTemplate.sendMsg(event, message);
                return false;
            }
            //不大于
            dto.setCount(count);
            repeatReadCache.put(groupId, dto);
            return true;
        }

        return true;
    }
}
