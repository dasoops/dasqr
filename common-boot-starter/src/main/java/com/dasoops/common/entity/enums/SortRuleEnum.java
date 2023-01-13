package com.dasoops.common.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: SortRuleEnum
 * @ClassPath com.dasoops.common.entity.enums.SortRuleEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 排序规则枚举
 * @see Enum
 */
@AllArgsConstructor
@Getter
public enum SortRuleEnum {

    /**
     * 降序
     */
    DESC(0),
    /**
     * 升序
     */
    ASC(1),
    ;

    final Integer integerValue;

}
