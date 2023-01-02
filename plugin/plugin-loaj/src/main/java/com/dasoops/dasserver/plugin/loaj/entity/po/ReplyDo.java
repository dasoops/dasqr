package com.dasoops.dasserver.plugin.loaj.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}