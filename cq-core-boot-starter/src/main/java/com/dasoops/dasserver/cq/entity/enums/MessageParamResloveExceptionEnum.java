package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.base.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @title MessageParamResloveExceptionEnum
 * @classPath com.dasoops.dasserver.cq.entity.enums.MessageParamResloveExceptionEnum
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/07
 * @version 1.0.0
 * @description 消息param解决异常枚举(102xx)
 * @see Enum
 */
@AllArgsConstructor
public enum MessageParamResloveExceptionEnum implements IExceptionEnum {

    /**
     * eem快速生成
     */
    PARAM_CLASS_ERROR("接收参数类型错误"),
    MESSAGE_TYPE_NOT_MATCH("messageType不匹配,仅支持groupMessage与privateMessage"),
    RETURN_TYPE_IS_NOT_PASSOBJ("方法返回值不可解析"),
    HAS_SAME_OR_LACK_ORDER("存在相同order或缺失order"),
    MESSAGE_PARAM_COUNT_OUT_OF_LIMIT("接收消息的param数量超出限制"),
    ;


    @Override
    public Integer getCode() {
        return 10200 + ordinal();
    }

    @Getter
    final String msg;
}
