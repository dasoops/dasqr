package com.dasoops.dasserver.plugin.loaj.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.dasoops.dasserver.cq.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ReplyPo
 * @ClassPath com.dasoops.dasserver.plugin.loaj.entity.po.ReplyPo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/11
 * @Version 1.0.0
 * @Description: 回复订单
 * @see BasePo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="TB_PLUGIN_LOAJ_REPLY")
@Data
public class ReplyPo extends BasePo implements Serializable {

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