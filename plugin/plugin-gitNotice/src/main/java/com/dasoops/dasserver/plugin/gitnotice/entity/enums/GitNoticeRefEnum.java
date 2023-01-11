package com.dasoops.dasserver.plugin.gitnotice.entity.enums;

import com.dasoops.common.entity.enums.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: GitNoticeRefEnum
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitNoticeRefEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: git通知分支枚举
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
