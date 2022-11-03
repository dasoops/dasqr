package com.dasoops.dasserver.cq.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: Plugin
 * @ClassPath com.dasoops.dasserver.cq.entity.po.Plugin
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 插件表, 储存插件注册信息, 权限, 描述, 启用状态等
 * @see BasePo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "TB_CORE_PLUGIN")
@Data
public class PluginPo extends BasePo implements Serializable {

    /**
     * 触发关键词
     */
    private String keyword;

    /**
     * 全类名
     */
    private String classPath;

    /**
     * 排序
     */
    private Integer order;

    /**
     * 权限等级
     */
    private Integer level;

    /**
     * 描述
     * 注意,该字段不可为空字符串,要表示没有内容请使用 "空" 或 "null"
     */
    private String description;

    /**
     * 是否启用
     */
    private Integer enable;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}