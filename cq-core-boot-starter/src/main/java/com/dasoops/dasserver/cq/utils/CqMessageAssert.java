package com.dasoops.dasserver.cq.utils;

import com.dasoops.common.util.Assert;
import com.dasoops.common.util.entity.AssertReslover;
import com.dasoops.common.util.entity.DefaultAssertReslover;
import com.dasoops.dasserver.cq.entity.enums.CqExceptionEnum;
import com.dasoops.dasserver.cq.exception.CqLogicException;

/**
 * @Title: Assert
 * @ClassPath com.dasoops.core.util.Assert
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: cq 断言工具类
 */
public class CqMessageAssert extends Assert {

    private static Assert instance;

    protected CqMessageAssert(AssertReslover reslover) {
        super(reslover);
    }

    public static Assert getInstance() {
        if (instance == null) {
            instance = new CqMessageAssert(new DefaultAssertReslover(){
                @Override
                public void allMustNull() {
                    throw new CqLogicException(CqExceptionEnum.PARAM_RESLOVE_ERROR);
                }

                @Override
                public void allMustNotNull() {
                    throw new CqLogicException(CqExceptionEnum.PARAM_RESLOVE_ERROR);
                }
            });
        }
        return instance;
    }

}
