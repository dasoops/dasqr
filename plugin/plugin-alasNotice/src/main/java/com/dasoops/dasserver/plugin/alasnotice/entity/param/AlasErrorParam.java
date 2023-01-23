package com.dasoops.dasserver.plugin.alasnotice.entity.param;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.common.entity.param.base.BaseFastBuildParam;
import com.dasoops.common.entity.param.base.BaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: AlasErrorParam
 * @ClassPath com.dasoops.dasserver.plugin.template.entity.param.AlasErrorParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: alasError推送 param
 * @see BaseFastBuildParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "alasError推送param", description = "alasError推送param")
public class AlasErrorParam extends BaseParam {

    /**
     * 用户id集合
     */
    @JSONField(name = "x_self_id")
    @ApiModelProperty(value = "用户id集合", notes = "用户id集合", example = "[776465218, 3488521150]", required = true)
    private List<Long> xSelfIdList;

    /**
     * 标题
     */
    @JSONField(name = "title")
    @ApiModelProperty(value = "标题", notes = "标题", example = "Alas <Dasoops> crashed", required = true)
    private String title;

    /**
     * 错误信息
     */
    @JSONField(name = "content")
    @ApiModelProperty(value = "错误信息", notes = "错误信息", example = "<Dasoops> GamePageUnknownError", required = true)
    private String content;

}
