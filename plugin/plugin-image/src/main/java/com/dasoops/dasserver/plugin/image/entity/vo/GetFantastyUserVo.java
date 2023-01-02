package com.dasoops.dasserver.plugin.image.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
import com.dasoops.dasserver.plugin.image.entity.dto.FantastyUserDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: GetFantastyUserVo
 * @ClassPath com.dasoops.dasserver.plugin.image.entity.vo.GetFantastyUserVo
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: 获取联想用户vo
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "获取联想用户vo", description = "获取联想用户vo")
public class GetFantastyUserVo extends BaseVo {

    /**
     * 联想用户集合
     */
    @ApiModelProperty(value = "联想用户集合", notes = "联想用户集合", example = "{\"registerId\":\"776465218\",\"name\":\"Das\"}", required = false)
    private List<FantastyUserDto> fantastyUserList;

}
