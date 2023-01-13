package com.dasoops.common.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.entity.enums.ISortColumnEnum;
import com.dasoops.common.entity.enums.SortRuleEnum;
import com.dasoops.common.entity.param.base.SortDataParam;
import com.dasoops.common.exception.LogicException;

import java.util.List;

/**
 * @Title: SortParamUtil
 * @ClassPath com.dasoops.common.util.SortParamUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/13
 * @Version 1.0.0
 * @Description: 排序param工具
 */
public class QueryWrapperUtil {

    public static <R extends BaseDo, E extends ISortColumnEnum> QueryWrapper<R> addSortParam(final QueryWrapper<R> wrapper, List<SortDataParam<R>> paramList, Class<E> enumClass) {
        if (wrapper == null) {
            throw new LogicException(ExceptionEnum.PARAMETER_NOT_NULL);
        }

        if (paramList == null || paramList.size() <= 0) {
            return wrapper;
        }

        paramList.forEach(param -> {
            SortRuleEnum sortRuleEnum = param.buildRuleEnum();
            E sortColumnEnum = param.buildColumnEnum(enumClass);
            wrapper.orderBy(true, sortRuleEnum.equals(SortRuleEnum.ASC), sortColumnEnum.getColumnName());
        });

        return wrapper;
    }

}
