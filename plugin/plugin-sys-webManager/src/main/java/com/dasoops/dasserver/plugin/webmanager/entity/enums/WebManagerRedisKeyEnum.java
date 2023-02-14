package com.dasoops.dasserver.plugin.webmanager.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.dasoops.common.entity.enums.base.BaseRedisKeyEnum.PLUGIN;

/**
 * @title: WebManagerRedisKeyEnum
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.enums.WebManagerRedisKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/02/13
 * @version 1.0.0
 * @description webManagerRedisKey枚举
 * @see Enum
 * @see IRedisKeyEnum
 */
@AllArgsConstructor
public enum WebManagerRedisKeyEnum implements IRedisKeyEnum {


    /**
     * groupId oto GroupUserIdSet
     * HASH<群id,<群用户id集合>>
     */
    GROUP_ID_OTM_GROUP_USER_ID_MAP(getBasePath() + "group_id_otm_group_user_id"),
    ;

    @Getter
    final String key;

    private static String getBasePath() {
        return PLUGIN + "webManager:";
    }
}
