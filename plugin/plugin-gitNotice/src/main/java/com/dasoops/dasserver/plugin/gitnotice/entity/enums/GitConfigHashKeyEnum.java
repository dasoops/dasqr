package com.dasoops.dasserver.plugin.gitnotice.entity.enums;

import com.dasoops.common.entity.enums.base.IRedisHashKeyEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title: GitConfigHashKeyEnum
 * @classPath com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitConfigHashKeyEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/11
 * @version 1.0.0
 * @description git配置hashKey枚举
 * @see IRedisHashKeyEnum
 */
@AllArgsConstructor
@Getter
public enum GitConfigHashKeyEnum implements IRedisHashKeyEnum {

    /**
     * git通知类型
     */
    GIT_NOTICE_TYPE("gitNoticeType"),
    /**
     * git通知群组
     */
    GIT_NOTICE_GROUP("gitNoticeGroup"),
    /**
     * git通知用户
     */
    GIT_NOTICE_USER("gitNoticeUser"),

    /**
     * git提醒分支
     */
    GIT_NOTICE_REFS("gitNoticeRefs"),

    /**
     * git重启提醒分支
     */
    GIT_REBOOT_NOTICE_REFS("gitRebootNoticeRefs"),
    /**
     * git提醒发送botId
     */
    GIT_NOTICE_X_SELF_ID("gitNoticeXSelfId"),
    ;

    final String key;
}
