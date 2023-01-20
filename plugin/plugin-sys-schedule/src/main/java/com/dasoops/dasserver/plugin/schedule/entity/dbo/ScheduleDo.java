package com.dasoops.dasserver.plugin.schedule.entity.dbo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @Title: ScheduleDo
 * @ClassPath com.dasoops.dasserver.plugin.schedule.entity.dbo.ScheduleDo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: plugin-sys-schedule 任务调度插件记录表
 * @see BaseDo
 * @see Serializable
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "tb_plugin_schedule")
@Data
public class ScheduleDo extends BaseDo implements Serializable {

    /**
     * cron表达式
     */
    private String cron;

    /**
     * 执行方法名
     */
    private String runMethod;

    /**
     * 执行方法类
     */
    private String runMethodClassName;

    /**
     * 执行方法参数类名
     */
    private String parameterClassName;

    /**
     * 执行方法参数(json格式)
     */
    private String parameterJson;

    /**
     * 是否启用
     */
    @TableField("`enable`")
    private Integer enable;
}