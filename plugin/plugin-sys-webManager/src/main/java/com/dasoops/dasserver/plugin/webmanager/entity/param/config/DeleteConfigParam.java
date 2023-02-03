package com.dasoops.dasserver.plugin.webmanager.entity.param.config;

import com.dasoops.common.entity.param.base.BaseDeleteParam;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: DeleteConfigParam
 * @ClassPath com.dasoops.dasserver.webManager.entity.param.DeleteConfigParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 删除配置参数
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "删除配置参数", description = "删除配置参数")
public class DeleteConfigParam extends BaseDeleteParam<ConfigDo> {

}
