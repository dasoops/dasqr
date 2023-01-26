package com.dasoops.dasserver.plugin.pluginwrapper.plugin;

import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.StrUtil;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.PluginStatusDto;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.entity.enums.PluginStatusEnum;
import com.dasoops.dasserver.cq.service.PluginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Title: plugin
 * @ClassPath com.dasoops.dasserver.core.plugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 插件
 * @see CqPlugin
 */
@Component
@Slf4j
public class GetPluginPlugin extends CqPlugin {

    @Override
    public CqPlugin getRawPlugin() {
        return this;
    }

    private final PluginService pluginService;

    public GetPluginPlugin(PluginService pluginService) {
        this.pluginService = pluginService;
    }

    @MessageMapping(equal = {"getPlugin", "getPluginList", "getAllPlugin", "allPlugin"}, type = MessageMappingTypeEnum.ALL)
    public String getAllPlugin() {
        List<PluginStatusDto> pluginStatusDtoList = pluginService.getAllPluginAndStatus();
        StringBuilder sb = new StringBuilder();

        pluginStatusDtoList.forEach(dto -> {
            sb.append(buildPluginStatusString(dto));
        });

        return sb.toString();
    }

    public String buildPluginStatusString(PluginStatusDto dto) {
        //获取插件名称
        String className = dto.getName();

        //启用状态
        PluginStatusEnum statusEnum = EnumUtil.getBy(PluginStatusEnum::getIntegerValue, dto.getStatus());

        Long rowId = dto.getRowId();
        String id = rowId.equals(-1L) ? "?" : String.valueOf(rowId);
        String description = dto.getDescription();

        //拼接
        String pluginStringFormat = "{}. {}({})[{}]\r\n";
        return StrUtil.format(pluginStringFormat, id, className, description, statusEnum.getStatusString());
    }

}
