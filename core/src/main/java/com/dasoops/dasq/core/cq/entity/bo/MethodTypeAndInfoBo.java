package com.dasoops.dasq.core.cq.entity.bo;

import lombok.Data;

/**
 * @Title: MethodTypeAndInfoBo
 * @ClassPath com.dasoops.dasq.core.cq.entity.bo.MethodTypeAndInfoBo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/11
 * @Version 1.0.0
 * @Description: 方法类型信息
 */
@Data
public class MethodTypeAndInfoBo {

    private String description;
    private String typeDescription;
    private String typeKeyword;
    private String param;

}
