package com.dasoops.dasq.core.common.entity;

import lombok.Data;

/**
 * @Title: ResqProperties
 * @ClassPath com.dasoops.dasq.core.common.entity.ResqProperties
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: resq属性
 */
@Data
public class DasqProperties {
    private Boolean consolePrintStack;
    private String token;
    private String cqHttpUrl;
    private String devGroupId;
    private String adminId;
    private Boolean isDemo;
    private String style;
    private String rebootShellPath;
}
