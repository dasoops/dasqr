package com.dasoops.dasserver.plugin.webmanager.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: GetConfigVo
 * @ClassPath com.dasoops.dasserver.sys.user.entity.vo.GetConfigVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 获取配置vo
 * @see BaseVo
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class GetConfigVo extends BaseVo {


    /**
     * id
     */
    @ApiModelProperty(value = "id", notes = "id", example = "1", required = true)
    private Long id;

    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字", notes = "关键字", example = "defaultStyle", required = true)
    private String keyword;

    /**
     * 值
     */
    @ApiModelProperty(value = "值", notes = "值", example = "cool", required = true)
    private String value;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述", notes = "描述", example = "默认风格", required = true)
    private String description;

    /**
     * 是否支持web端修改(0:false;1:true)
     */
    @ApiModelProperty(value = "是否支持web端修改", notes = "是否支持web端修改(0:false;1:true)", allowableValues = "0,1", example = "0", required = true)
    private Integer canEdit;

}
