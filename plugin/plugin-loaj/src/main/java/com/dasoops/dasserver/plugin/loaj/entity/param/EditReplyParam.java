package com.dasoops.dasserver.plugin.loaj.entity.param;

import com.baomidou.mybatisplus.annotation.TableField;
import com.dasoops.common.entity.param.base.BaseEditParam;
import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: EditReplyParam
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.param.EditReplyParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/26
 * @Version 1.0.0
 * @Description: 编辑回复param
 * @see BaseEditParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EditReplyParam extends BaseEditParam<ReplyDo> {


    /**
     * 触发关键词
     */
    @ApiModelProperty(value = "触发关键词", notes = "触发关键词", example = "傻狗", required = true)
    private String keyword;

    /**
     * 回复
     */
    @ApiModelProperty(value = "回复", notes = "回复", example = "傻狗叫谁", required = true)
    private String reply;

    /**
     * 匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)
     */
    @ApiModelProperty(value = "匹配类型", notes = "匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)", example = "0", required = true)
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

    /**
     * 是否启用
     */
    @ApiModelProperty(value = "是否启用", notes = "是否启用", example = "1", required = true)
    @TableField("`enable`")
    private Integer enable;

}
