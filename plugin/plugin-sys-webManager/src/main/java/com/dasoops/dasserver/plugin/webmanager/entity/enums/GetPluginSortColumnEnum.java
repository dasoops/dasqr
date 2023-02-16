package com.dasoops.dasserver.plugin.webmanager.entity.enums;

import com.dasoops.common.entity.enums.base.ISortColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title GetPluginOrderColumnEnum
 * @classPath com.dasoops.dasserver.plugin.webmanager.entity.enums.GetPluginOrderColumnEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/12
 * @version 1.0.0
 * @description 获取插件分页信息按字段排序枚举
 */
@AllArgsConstructor
@Getter
public enum GetPluginSortColumnEnum implements ISortColumnEnum {

    /**
     * 主键id
     */
    ROW_ID(0, "`row_id`"),
    /**
     * 排序字段
     */
    ORDER(1, "`order`"),
    /**
     * level字段
     */
    LEVEL(2, "`level`"),
    /**
     * enable字段
     */
    ENABLE(3, "`enable`"),
    ;

    final Integer integerValue;
    final String columnName;
}
