package com.dasoops.dasserver.plugin.shell.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import com.dasoops.common.entity.vo.base.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title LogVo
 * @classPath com.dasoops.dasserver.plugin.shell.entity.vo.LogVo
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/25
 * @version 1.0.0
 * @description 日志dto
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
