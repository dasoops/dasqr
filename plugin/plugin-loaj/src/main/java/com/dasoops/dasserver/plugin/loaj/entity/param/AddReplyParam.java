package com.dasoops.dasserver.plugin.loaj.entity.param;

import com.dasoops.common.entity.param.base.BaseAddParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: AddReplyParam
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.param.AddReplyParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/26
 * @Version 1.0.0
 * @Description: 添加回复param
 * @see BaseAddParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "添加回复param", description = "添加回复param")
public class AddReplyParam extends BaseAddParam<ReplyDo> {

    /**
     * 触发关键词
     */
    @ApiModelProperty(value = "触发关键词", notes = "触发关键词", example = "傻狗", required = true)
    @InjectionParam(order = 0)
    private String keyword;

    /**
     * 回复
     */
    @ApiModelProperty(value = "回复", notes = "回复", example = "傻狗叫谁", required = true)
    @InjectionParam(order = 1)
    private String reply;

    /**
     * 匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)
     */
    @ApiModelProperty(value = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)", notes = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)", example = "0", required = true)
    private Integer matchType;

    /**
     * 忽略大小写
     */
    @ApiModelProperty(value = "忽略大小写", notes = "忽略大小写", example = "0", required = true)
    private Integer ignoreCase;

    /**
     * 忽略全半角
     */
    @ApiModelProperty(value = "忽略全半角", notes = "忽略全半角", example = "0", required = true)
    private Integer ignoreDbc;

}
