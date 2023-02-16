package com.dasoops.dasserver.plugin.exec.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import com.dasoops.dasserver.cq.entity.annocation.InjectionParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title ExecParam
 * @classPath com.dasoops.dasserver.plugin.exec.entity.param.ExecParam
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/18
 * @version 1.0.0
 * @description 执行param
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
