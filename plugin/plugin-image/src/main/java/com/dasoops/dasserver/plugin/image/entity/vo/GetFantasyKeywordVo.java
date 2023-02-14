package com.dasoops.dasserver.plugin.image.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @title: GetFantasyKeywordVo
 * @classPath com.dasoops.dasserver.plugin.image.entity.vo.GetFantasyKeywordVo
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 获取联想关键词vo
 * @see BaseVo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取联想关键词vo", description = "获取联想关键词vo")
public class GetFantasyKeywordVo extends BaseVo {

    /**
     * 联想关键词集合
     */
    @ApiModelProperty(value = "联想关键词集合", notes = "联想关键词集合", example = "我", required = false)
    private List<String> keywordList;

}
