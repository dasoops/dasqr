package com.dasoops.dasq.core.cq.util;

import cn.hutool.core.util.StrUtil;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.util.EventUtil;
import com.dasoops.dasq.core.cq.entity.enums.DqCodeEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Title: CqMethodUtil
 * @ClassPath com.dasoops.dasq.core.cq.util.CqMethodUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: cq Method Util
 */
public class CqMethodUtil {

    public static List<String> getParameterMap(String parameterStr, String message) {

        //message转义
        String finalMessage = message.replace("\\,", "${comma}");

        //去除前后缀
        parameterStr = StrUtil.removePrefix(parameterStr, "{");
        parameterStr = StrUtil.removeSuffix(parameterStr, "}");

        //分割
        List<String> resStrList = StrUtil.split(parameterStr, ",");

        for (int i = 0; i < resStrList.size(); i++) {
            int index = i;
            String s = resStrList.get(i);
            //获取其中的DQ指示符
            Arrays.stream(DqCodeEnum.values())
                    .filter(res -> res.getDqCode().equals(s)).findFirst()
                    //对其中的指示符进行解析
                    .ifPresent(res -> resStrList.set(index, parseDqCode(res, finalMessage)));
        }
        //message转义
        resStrList.replaceAll(res -> res.replace("${comma}", ","));
        return resStrList;
    }

    public static String parseDqCode(DqCodeEnum dqCode, String message) {
        switch (dqCode) {
            case AUTHOR_TYPE:
                return String.valueOf(EventUtil.get().getMessageType());
            case AUTHOR_ID:
                EventInfo eventInfo = EventUtil.get();
                Integer messageType = eventInfo.getMessageType();
                switch (messageType) {
                    case 0:
                        return String.valueOf(eventInfo.getGroupId());
                    case 1:
                        return String.valueOf(eventInfo.getAuthorId());
                    default:
                        return null;
                }
            case PARAM0:
                return getMethodParam(message, 0);
            case PARAM1:
                return getMethodParam(message, 1);
            case PARAM2:
                return getMethodParam(message, 2);
            case PARAM3:
                return getMethodParam(message, 3);
            case PARAM4:
                return getMethodParam(message, 4);
            case PARAM5:
                return getMethodParam(message, 5);
            case PARAM6:
                return getMethodParam(message, 6);
            case PARAM7:
                return getMethodParam(message, 7);
            case PARAM8:
                return getMethodParam(message, 8);
            case PARAM9:
                return getMethodParam(message, 9);
            case PARAM10:
                return getMethodParam(message, 10);
            default:
                return null;
        }
    }

    public static String getMethodParam(String message, Integer index) {
        int i = message.indexOf("(");
        if (i == -1) {
            return null;
        }
        String paramStr = message.substring(i + 1, message.length() - 1);
        List<String> split = StrUtil.split(paramStr, ",");
        return split.get(index);
    }

}
