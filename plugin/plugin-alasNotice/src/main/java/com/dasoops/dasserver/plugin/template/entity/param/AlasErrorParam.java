package com.dasoops.dasserver.plugin.template.entity.param;

import com.alibaba.fastjson2.annotation.JSONField;
import com.dasoops.common.entity.param.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: AlasErrorParam
 * @ClassPath com.dasoops.dasserver.plugin.template.entity.param.AlasErrorParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/11
 * @Version 1.0.0
 * @Description: alasError推送 param
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AlasErrorParam extends BaseParam {

    /**
     * 用户id集合
     */
    @JSONField(name = "x_self_id")
    private List<Long> xSelfIdList;

    /**
     * 错误信息
     */
    @JSONField(name = "content")
    private String content;

}
