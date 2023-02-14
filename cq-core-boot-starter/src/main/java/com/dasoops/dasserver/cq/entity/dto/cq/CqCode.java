package com.dasoops.dasserver.cq.entity.dto.cq;

import com.dasoops.dasserver.cq.entity.enums.CqCodeTypeEnum;
import lombok.Data;

import java.util.Map;

/**
 * @title: CqCode
 * @classPath com.dasoops.dasserver.cq.entity.dto.cq.CqCode
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/07
 * @version 1.0.0
 * @description cq码解析后对象
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
