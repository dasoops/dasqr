package com.dasoops.dasserver.plugin.gitnotice.entity.enums;

import com.dasoops.common.entity.enums.IDbColumnEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: GitNoticeBotXSelfIdEnum
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitNoticeBotXSelfIdEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: git通知botId
 * @see Enum
 * @see IDbColumnEnum
 */
@AllArgsConstructor
@Getter
public enum GitNoticeBotXSelfIdEnum {

    /**
     * 所有
     */
    ALL("all");

    final String dbValue;

}
