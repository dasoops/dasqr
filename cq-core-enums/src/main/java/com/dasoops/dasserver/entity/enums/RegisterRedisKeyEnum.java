package com.dasoops.dasserver.entity.enums;

import com.dasoops.common.entity.enums.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: RegisterRedisKeyEnum
 * @ClassPath com.dasoops.dasserver.entity.enums.RegisterRedisKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 注册表redisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
@Getter
public enum RegisterRedisKeyEnum implements IRedisKeyEnum {

    /**
     * 注册表用户id名称映射表
     */
    REGISTER_ID_OTO_NAME_MAP(REGISTER + "id_oto_name"),
    /**
     * 注册表用户id类型映射表
     */
    REGISTER_ID_OTO_TYPE_MAP(REGISTER + "id_oto_type"),
    /**
     * 注册表(用户) 注册表id单对单id映射集合
     */
    REGISTER_USER_ROW_ID_OTO_ID_MAP(REGISTER + "register_row_id_oto_id:user"),
    /**
     * 注册表(群组) 注册表id单对单id映射集合
     */
    REGISTER_GROUP_ROW_ID_OTO_ID_MAP(REGISTER + "register_row_id_oto_id:group"),
    ;
    final String key;

}
