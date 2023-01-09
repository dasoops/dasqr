package com.dasoops.dasserver.cq.entity.enums;

import com.dasoops.common.entity.enums.IExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Title: MessageParamResloveExceptionEnum
 * @ClassPath com.dasoops.dasserver.cq.entity.enums.MessageParamResloveExceptionEnum
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/07
 * @Version 1.0.0
 * @Description: 消息param解决异常枚举(106xx)
 * @see Enum
 */
@AllArgsConstructor
@Getter
public enum MessageParamResloveExceptionEnum implements IExceptionEnum {

    /***/
    PARAM_CLASS_ERROR(10601, "接收参数类型错误"),
    MESSAGE_TYPE_NOT_MATCH(10602, "messageType不匹配,仅支持groupMessage与privateMessage"),
    RETURN_TYPE_IS_NOT_PASSOBJ(10603, "方法返回值不可解析"),
    HAS_SAME_OR_LACK_ORDER(10604, "存在相同order或缺失order"),
    MESSAGE_PARAM_COUNT_OUT_OF_LIMIT(10608, "接收消息的param数量超出限制"),
    ;
    final Integer code;
    final String msg;
}
