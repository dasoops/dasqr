package com.dasoops.common.entity.param.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dasoops.common.entity.dbo.base.BaseDo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BasePageParam
 * @ClassPath com.dasoops.common.entity.param.base.BasePageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 基本页面参数
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BasePageParam<T extends BaseDo> extends BaseParam<T> implements IBuildSelectPage<T>{

    /**
     * 每页显示数量
     */
    @ApiModelProperty(value = "每页显示数量", notes = "每页显示数量", required = false)
    private Integer size = 10;

    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码", notes = "当前页码", required = false)
    private Integer current = 1;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数", notes = "总记录数", required = false)
    private Integer total;

    @Override
    public IPage<T> buildSelectPage() {
        Page<T> page = new Page<>(this.getCurrent(), this.getSize());
        return page;
    }

}
