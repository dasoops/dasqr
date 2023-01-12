package com.dasoops.common.entity.param.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BaseEditParam
 * @ClassPath com.dasoops.common.entity.param.base.BaseEditParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 编辑param基类
 * @see BaseParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEditAndDeleteParam extends BaseParam {

    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", notes = "主键id", example = "1", required = true)
    private Long rowId;

}
