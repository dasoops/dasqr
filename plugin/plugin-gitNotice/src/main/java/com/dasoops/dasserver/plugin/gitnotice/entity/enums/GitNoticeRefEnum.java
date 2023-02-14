package com.dasoops.dasserver.plugin.gitnotice.entity.enums;

import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: GitNoticeRefEnum
 * @classPath com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitNoticeRefEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/11
 * @version 1.0.0
 * @description git通知分支枚举
 * @see Enum
 * @see IDbColumnEnum
 */
@AllArgsConstructor
@Getter
public enum GitNoticeRefEnum {

    /**
     * 所有
     */
    ALL("all");

    final String dbValue;

}
