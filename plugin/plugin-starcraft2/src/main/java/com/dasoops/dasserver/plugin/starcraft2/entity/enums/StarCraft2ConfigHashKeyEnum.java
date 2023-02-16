package com.dasoops.dasserver.plugin.starcraft2.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title StarCraft2ConfigHashKeyEnum
 * @classPath com.dasoops.dasserver.plugin.starcraft2.entity.enums.StarCraft2ConfigHashKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/20
 * @version 1.0.0
 * @description 星际2configKey
 * @see Enum
 * @see IRedisHashKeyEnum
 */
@AllArgsConstructor
@Getter
public enum StarCraft2ConfigHashKeyEnum implements IRedisHashKeyEnum {

    /**
     * 突变记录(rowId)
     */
    MUTATION_RECORD("starCraft2MutationRecord");

    final String key;

}
