package com.dasoops.dasserver.plugin.exec.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: ExecParam
 * @ClassPath com.dasoops.dasserver.plugin.exec.entity.param.ExecParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/18
 * @Version 1.0.0
 * @Description: 执行param
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ExecParam extends BaseParam {

    /**
     * exec文件关键字
     */
    @InjectionParam(order = 0)
    private String execFileKeyword;

}
