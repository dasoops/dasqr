package com.dasoops.dasserver.plugin.loaj.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Title: ReplyPo
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.po.ReplyPo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/11
 * @Version 1.0.0
 * @Description: 回复订单
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="tb_plugin_loaj_reply")
@Data
public class ReplyDo extends BaseDo implements Serializable {

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
}