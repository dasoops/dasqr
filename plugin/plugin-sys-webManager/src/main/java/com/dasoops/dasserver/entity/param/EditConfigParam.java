package com.dasoops.dasserver.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: EditConfigParam
 * @ClassPath com.dasoops.dasserver.entity.param.EditConfigParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/30
 * @Version 1.0.0
 * @Description: 编辑配置参数
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EditConfigParam extends BaseParam {

    /**
     * id
     */
    private Long id;
    /**
     * 配置项关键词
     */
    private String keyword;

    /**
     * 配置项属性值
     */
    private String value;

    /**
     * 描述
     */
    private String description;

}
