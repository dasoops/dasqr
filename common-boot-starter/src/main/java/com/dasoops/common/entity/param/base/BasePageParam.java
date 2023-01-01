package com.dasoops.common.entity.param.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BasePageParam
 * @ClassPath com.dasoops.common.entity.param.base.BasePageParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 基本页面参数
 * @see BaseEasyPageParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BasePageParam extends BaseEasyPageParam {

    public <T extends BaseDo> IPage<T> getSelectPage() {
        Page<T> page = new Page<>(super.getCurrent(),super.getSize());
        return page;
    }

}
