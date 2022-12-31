package com.dasoops.dasserver.cq.utils;

import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.entity.AssertReslover;
import com.dasoops.dasserver.cq.exception.CqLogicException;

/**
 * @Title: Assert
 * @ClassPath com.dasoops.core.util.Assert
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: cq 断言工具类
 */
public class CqAssert extends Assert {

    static {
        setReslover(new AssertReslover() {
            @Override
            public void allMustNull() {
                throw new CqLogicException(ExceptionEnum.PARAMETER_IS_NULL);
            }

            @Override
            public void allMustNotNull() {
                throw new CqLogicException(ExceptionEnum.PARAMETER_NOT_NULL);
            }

            @Override
            public void isTrue() {
                throw new CqLogicException(ExceptionEnum.IS_TRUE);
            }

            @Override
            public void isFalse() {
                throw new CqLogicException(ExceptionEnum.IS_FALSE);
            }

            @Override
            public void dbExecuteMustSuccess() {
                throw new CqLogicException(ExceptionEnum.DB_EXECUTE_FAILED);
            }

            @Override
            public void dbExecuteReturnMustNotNull() {
                throw new CqLogicException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_NULL);
            }

            @Override
            public void dbExecuteResNotZero() {
                throw new CqLogicException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_ZERO);
            }
        });
    }

}
