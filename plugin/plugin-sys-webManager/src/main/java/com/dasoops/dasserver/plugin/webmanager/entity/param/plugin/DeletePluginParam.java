package com.dasoops.dasserver.plugin.webmanager.entity.param.plugin;

import com.dasoops.common.entity.param.base.BaseEditAndDeleteParam;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title DeletePluginParam
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.param.plugin.DeletePluginParam
 * @date 2023/01/12
 * @description 删除插件param
 * @see BaseEditAndDeleteParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Api("Plugin")
@ApiModel(value = "删除插件param", description = "删除插件param")
public class DeletePluginParam extends BaseEditAndDeleteParam<PluginDo> {

}