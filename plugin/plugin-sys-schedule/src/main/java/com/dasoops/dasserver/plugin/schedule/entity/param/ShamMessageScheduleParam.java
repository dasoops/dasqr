package com.dasoops.dasserver.plugin.schedule.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ShamMessageScheduleParam
 * @ClassPath com.dasoops.dasserver.plugin.schedule.entity.param.ShamMessageScheduleParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 虚假消息定时任务param
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShamMessageScheduleParam extends BaseParam {
    /**
     * 消息
     */
    private String message;

    /**
     * 虚拟群
     */
    private Long groupId;

    /**
     * 虚拟用户
     */
    private Long userId;

    /**
     * botId,没有代表所有
     */
    private Long xSelfId;

    /**
     * 是否只执行一次
     */
    private Boolean onlyOnce;
}