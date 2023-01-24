package com.dasoops.dasserver.plugin.shell.entity.vo;

import com.dasoops.common.entity.dto.base.BaseDto;
import com.dasoops.common.entity.vo.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: LogVo
 * @ClassPath com.dasoops.dasserver.plugin.shell.entity.vo.LogVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/25
 * @Version 1.0.0
 * @Description: 日志dto
 * @see BaseVo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LogDto extends BaseDto {

    /**
     * level
     */
    private String level;

    /**
     * 消息
     */
    private String msg;

}
