package com.dasoops.dasq.core.cq.entity.bo;

import lombok.Data;

/**
 * @Title: PassKeywordGetMethodInfoIdBo
 * @ClassPath com.dasoops.dasq.core.cq.entity.bo.PassKeywordGetMethodInfoIdBo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: 通过关键字获取方法信息id bo
 */
@Data
public class PassKeywordGetMethodInfoIdBo {

    /**
     * methodInfoId
     */
    private Long id;

    /**
     * 关键字
     */
    private String keyword;

}
