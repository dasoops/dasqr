package com.dasoops.dasserver.entity.vo;

import com.dasoops.common.entity.vo.base.BaseVo;
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
    private Long id;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 值
     */
    private String value;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否支持web端修改(0:false;1:true)
     */
    private Integer canEdit;

}
