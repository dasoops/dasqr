package com.dasoops.dasserver.plugin.gitnotice;

import com.dasoops.dasserver.plugin.gitnotice.entity.enums.GitNoticeTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Title: GitNoticeProperties
 * @ClassPath com.dasoops.dasserver.plugin.gitnotice.GitNoticeProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/03
 * @Version 1.0.0
 * @Description: git上报通知配置
 */
@ConfigurationProperties(prefix = "dasq.plugin.git-notice")
@Getter
@Setter
public class GitNoticeProperties {
    /**
     * noticeType 消息上报类型
     * @see GitNoticeTypeEnum
     */
    private String noticeType = "coreGroupAtUser";

    /**
     * notice 群组id
     */
    private int noticeGroupId;
    /**
     * notice at用户id
     */
    private int noticeUserId;
}
