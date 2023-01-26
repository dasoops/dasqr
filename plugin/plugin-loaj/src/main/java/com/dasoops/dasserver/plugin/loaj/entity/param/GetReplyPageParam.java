package com.dasoops.dasserver.plugin.loaj.entity.param;

import com.dasoops.common.entity.param.base.BasePageParam;
import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: GetReplyPageParam
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.param.GetReplyPageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/26
 * @Version 1.0.0
 * @Description: 获取回复页面param
 * @see BasePageParam
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取回复页面param", description = "获取回复页面param")
public class GetReplyPageParam extends BasePageParam<ReplyDo> {

    /**
     * 匹配关键词(keyword || reply)
     */
    @ApiModelProperty(value = "like 关键字", notes = "like 关键字", example = "傻狗", required = false)
    private String matchKeyword;

    /**
     * 匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)
     */
    @ApiModelProperty(value = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)", notes = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)", example = "[0,1]", required = false)
    private List<Integer> matchTypeList;
}
