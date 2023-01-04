package com.dasoops.dasserver.plugin.webmanager.util;

import com.dasoops.common.entity.enums.ExceptionEnum;
import com.dasoops.common.exception.WebLogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.entity.AssertReslover;

/**
 * @Title: WebAssert
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.util.WebAssert
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/31
 * @Version 1.0.0
 * @Description: web 断言工具类
 * @see Assert
 */
public class WebAssert extends Assert {

    static {
        setReslover(new AssertReslover() {
            @Override
            public void allMustNull() {
                throw new WebLogicException(ExceptionEnum.PARAMETER_IS_NULL);
            }

            @Override
            public void allMustNotNull() {
                throw new WebLogicException(ExceptionEnum.PARAMETER_NOT_NULL);
            }

            @Override
            public void isTrue() {
                throw new WebLogicException(ExceptionEnum.IS_TRUE);
            }

            @Override
            public void isFalse() {
                throw new WebLogicException(ExceptionEnum.IS_FALSE);
            }

            @Override
            public void dbExecuteMustSuccess() {
                throw new WebLogicException(ExceptionEnum.DB_EXECUTE_FAILED);
            }

            @Override
            public void dbExecuteReturnMustNotNull() {
                throw new WebLogicException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_NULL);
            }

            @Override
            public void dbExecuteResNotZero() {
                throw new WebLogicException(ExceptionEnum.DB_EXECUTE_RETURN_NOT_ZERO);
            }
        });
    }
}
