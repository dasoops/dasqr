package com.dasoops.dasserver.cq.exception;

import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.WrapperGlobal;
import com.dasoops.dasserver.cq.conf.properties.CqProperties;
import com.dasoops.dasserver.cq.wrapper.ExceptionWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ExceptionTemplate {

    private final CqProperties cqProperties;

    public void resloveException(Exception e) {
        //异常处理
        Assert.getInstance().ifTrue(
                cqProperties.isConsolePrintStack(),
                () -> Assert.getInstance().ifTrueOrElse(
                        cqProperties.isNativePrintStack(),
                        e::printStackTrace,
                        () -> log.error("消息处理发生异常: {}", e instanceof LogicException logicException ? logicException.getStackMessage() : e)
                ));
        List<ExceptionWrapper> exceptionWrapperList = WrapperGlobal.getExceptionWrapperList();
        Assert.getInstance().ifNotNull(exceptionWrapperList, () -> exceptionWrapperList.forEach(exceptionWrapper -> exceptionWrapper.invoke(e)));
    }

}
