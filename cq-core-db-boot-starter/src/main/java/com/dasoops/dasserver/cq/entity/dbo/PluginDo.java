package com.dasoops.dasserver.cq.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @title Plugin
 * @classPath com.dasoops.dasserver.cq.entity.po.Plugin
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 插件表, 储存插件注册信息, 权限, 描述, 启用状态等
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "tb_core_plugin")
@Data
public class PluginDo extends BaseDo implements Serializable {

    /**
     * 触发关键词
     */
    @TableField("`name`")
    private String name;

    /**
     * 全类名
     */
    private String classPath;

    /**
     * 排序
     */
    @TableField("`order`")
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
}