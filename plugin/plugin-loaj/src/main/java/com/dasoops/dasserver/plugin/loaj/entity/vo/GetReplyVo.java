package com.dasoops.dasserver.plugin.loaj.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.dasoops.common.entity.vo.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetReplyVo
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.vo.GetReplyVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/26
 * @Version 1.0.0
 * @Description: 获取回复vo
 * @see BaseVo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GetReplyVo extends BaseVo {

    /**
     * 触发关键词
     */
    private String keyword;

    /**
     * 回复
     */
    private String reply;

    /**
     * 匹配类型(0:全局匹配;1:前缀匹配;2:后缀匹配;3:包含匹配)
     */
    private Integer matchType;

    /**
     * 忽略大小写
     */
    private Integer ignoreCase;

    /**
     * 忽略全半角
     */
    private Integer ignoreDbc;

    /**
     * 是否启用
     */
    @TableField("`enable`")
    private Integer enable;

}
