package com.dasoops.dasserver.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: AuthUserDto
 * @ClassPath com.dasoops.dasserver.entity.dto.AuthUserDto
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/29
 * @Version 1.0.0
 * @Description: 身份验证用户dto
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AuthUserDto extends BaseDto {

    /**
     * id
     */
    private Long id;

    /**
     * 注册者id
     */
    private Long registerId;

}
