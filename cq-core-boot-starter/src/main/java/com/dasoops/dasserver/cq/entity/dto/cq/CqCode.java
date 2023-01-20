package com.dasoops.dasserver.cq.entity.dto.cq;

import com.dasoops.dasserver.cq.entity.enums.CqCodeTypeEnum;
import lombok.Data;

import java.util.Map;

/**
 * @Title: CqCode
 * @ClassPath com.dasoops.dasserver.cq.entity.dto.cq.CqCode
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/07
 * @Version 1.0.0
 * @Description: cq码解析后对象
 */
@Data
public class CqCode {

    /**
     * 类型
     */
    private CqCodeTypeEnum typeEnum;

    /**
     * 参数个数
     */
    private Map<String, String> param;

}
