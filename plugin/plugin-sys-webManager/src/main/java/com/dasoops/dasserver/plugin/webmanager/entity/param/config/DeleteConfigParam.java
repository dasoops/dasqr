package com.dasoops.dasserver.plugin.webmanager.entity.param.config;

import com.dasoops.common.entity.param.base.BaseDeleteParam;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title: DeleteConfigParam
 * @classPath com.dasoops.dasserver.webManager.entity.param.DeleteConfigParam
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/30
 * @version 1.0.0
 * @description 删除配置参数
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "删除配置参数", description = "删除配置参数")
public class DeleteConfigParam extends BaseDeleteParam<ConfigDo> {

}
