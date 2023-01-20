package com.dasoops.dasserver.plugin.starcraft2.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: StarCraft2ConfigHashKeyEnum
 * @ClassPath com.dasoops.dasserver.plugin.starcraft2.entity.enums.StarCraft2ConfigHashKeyEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/20
 * @Version 1.0.0
 * @Description: 星际2configKey
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
