package com.dasoops.dasq.core.common.util;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.exception.entity.LogicException;
import com.dasoops.common.exception.entity.enums.ExceptionCodeEnum;
import com.dasoops.dasq.core.common.entity.EventInfo;
import com.dasoops.dasq.core.common.entity.enums.KeywordEnum;
import com.dasoops.dasq.core.cq.entity.enums.DqCodeEnum;

import java.util.*;

/**
 * @Title: CqMethodUtil
 * @ClassPath com.dasoops.dasq.core.common.util.CqMethodUtil
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: cq Method Util
 */
public class CqMethodUtil {

    /**
     * 得到消息参数集合
     *
     * @param parameterStr 参数str
     * @param message      消息
     * @return {@link List}<{@link String}>
     */
    public static List<String> getParameterMap(String parameterStr, String message, String style) {

        //cq码,转义
        //获取匹配的CQ码
        Optional<String> matchStrOpt = RegexUtil.getMatchStr("\\[CQ:\\w+?.*?]", message);
        if (matchStrOpt.isPresent()) {
            //CQ码内部转义
            String matchStr = matchStrOpt.get();
            String replaceStr = matchStr.replace(",", "\\,");
            //覆盖原CQ码
            message = message.replace(matchStr, replaceStr);
        }

        //message转义
        parameterStr = parameterStr.replace("\\,", "${comma}");
        message = message.replace("\\,", "${comma}");

        //获取消息参数集合
        List<String> messageParamList = new ArrayList<>();
        Optional<List<String>> messageParamListOpt = getParamList(message, style);
        if (messageParamListOpt.isPresent()) {
            messageParamList = messageParamListOpt.get();
        }

        List<String> finalMessageParamList = messageParamList;

        //去除前后缀
        parameterStr = StrUtil.removePrefix(parameterStr, "{");
        parameterStr = StrUtil.removeSuffix(parameterStr, "}");

        //分割
        List<String> dcParamList = StrUtil.split(parameterStr, ",");

        //解析置入
        for (int i = 0; i < dcParamList.size(); i++) {
            int index = i;
            String s = dcParamList.get(i);
            //获取其中的DQ指示符
            Arrays.stream(DqCodeEnum.values())
                    .filter(res -> res.getDqCode().equals(s)).findFirst()
                    //对其中的指示符进行解析
                    .ifPresent(res -> dcParamList.set(index, parseDqCode(res, finalMessageParamList)));
        }

        //message转义
        dcParamList.replaceAll(res -> {
            if (res == null) {
                return null;
            }
            return res.replace("${comma}", ",");
        });
        return dcParamList;
    }

    public static String parseDqCode(DqCodeEnum dqCode, List<String> paramList) {
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
                return getParam(paramList, 0);
            case PARAM1:
                return getParam(paramList, 1);
            case PARAM2:
                return getParam(paramList, 2);
            case PARAM3:
                return getParam(paramList, 3);
            case PARAM4:
                return getParam(paramList, 4);
            case PARAM5:
                return getParam(paramList, 5);
            case PARAM6:
                return getParam(paramList, 6);
            case PARAM7:
                return getParam(paramList, 7);
            case PARAM8:
                return getParam(paramList, 8);
            case PARAM9:
                return getParam(paramList, 9);
            case PARAM10:
                return getParam(paramList, 10);
            default:
                return null;
        }
    }

    public static Optional<List<String>> getParamList(String message, String style) {

        //根据模式获取参数
        int i;
        if (KeywordUtil.isCool(style)) {
            i = message.indexOf(" ");
        } else if (KeywordUtil.isNormal(style)) {
            i = message.indexOf("(");
        } else {
            throw new LogicException(ExceptionCodeEnum.PARAMETER_STYLE_ERROR);
        }

        //没有参数
        if (i == -1) {
            return Optional.empty();
        }

        //提取参数字符串
        String paramStr = message.substring(i + 1, KeywordUtil.isNormal(style) ? message.length() - 1 : message.length());
        return Optional.of(StrUtil.split(paramStr, ","));
    }

    private static String getParam(List<String> strList, int index) {
        if (strList.size() < index + 1) {
            return null;
        }
        return strList.get(index);
    }

}
