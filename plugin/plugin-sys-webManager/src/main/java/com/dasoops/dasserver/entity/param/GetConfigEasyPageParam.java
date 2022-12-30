package com.dasoops.dasserver.entity.param;

import com.dasoops.common.entity.param.base.BaseEasyPageParam;
import com.dasoops.common.entity.param.base.BasePageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetConfigParam
 * @ClassPath com.dasoops.dasserver.sys.user.entity.param.GetConfigParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 获取配置参数
 * @see BaseEasyPageParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GetConfigEasyPageParam extends BasePageParam {
    /**
     * 关键字
     */
    private String keyword;
    /**
     * 描述
     */
    private String description;
}
