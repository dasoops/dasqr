package com.dasoops.dasserver.cq.utils;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.StrUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @title DqUtil
 * @classPath com.dasoops.dasserver.cq.utils.DqUtil
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/07
 * @version 1.0.0
 * @description dq工具类
 */
public class DqCodeUtil {

    /**
     * 获取paramstr
     * 得到参数str
     *
     * @param message   消息
     * @param prefix    前缀
     * @param separator 分隔符
     * @param ignoreDbc 忽略dbc
     * @param skipCq    不以cq中的字符串切分
     * @param needTrim  是否消除两边空格
     * @return {@link List}<{@link String}>
     */
    public static List<String> getParamStr(String message, String prefix, String suffix, String separator, boolean ignoreDbc, boolean skipCq, boolean needTrim) {
        final String placeholder = "&>.<&";

        //消除前缀
        message = StrUtil.removePrefixIgnoreCase(message, prefix);

        //消除后缀
        message = StrUtil.removeSuffixIgnoreCase(message, suffix);

        //消除左边空格
        if (needTrim) {
            message = message.trim();
        }

        //是否忽略全角标点
        if (ignoreDbc) {
            message = Convert.toDBC(message.replace("。", "."));
        }

        //是否解析时跳过CqCode
        if (!skipCq) {
            return StrUtil.split(message, separator);
        }

        //是否包含cqCode
        Optional<List<String>> cqCodeListOpt = CqCodeUtil.getCqCode(message);
        if (cqCodeListOpt.isPresent()) {
            List<String> cqCodeList = cqCodeListOpt.get();

            //替换过来
            for (String cqCodeStr : cqCodeList) {
                message = message.replace(cqCodeStr, placeholder);
            }

            //分隔
            List<String> split = StrUtil.split(message, separator);

            //替换回去
            Iterator<String> iterator = cqCodeList.iterator();

            return split.stream().map(str -> {
                if (str.contains(placeholder)) {
                    String next = iterator.next();
                    return next;
                }
                return str;
            }).collect(Collectors.toList());
        }

        List<String> split = StrUtil.split(message, separator);
        if (split.isEmpty() || ObjUtil.isEmpty(split.get(0))) {
            return new ArrayList<>();
        }
        return split;
    }

    /**
     * @param message   消息
     * @param prefix    前缀
     * @param separator 分隔符
     * @return {@link List}<{@link String}>
     */
    public static List<String> getParamStr(String message, String prefix, String separator) {
        return getParamStr(message, prefix, "", separator, true, true, true);
    }

    /**
     * 得到参数str
     *
     * @param message   消息
     * @param prefix    前缀
     * @param ignoreDbc 忽略dbc
     * @return {@link List}<{@link String}>
     */
    public static List<String> getParamStr(String message, String prefix, boolean ignoreDbc) {
        return getParamStr(message, prefix, "", ",", ignoreDbc, true, true);
    }

    /**
     * 得到参数str
     *
     * @param message 消息
     * @param prefix  前缀
     * @return {@link List}<{@link String}>
     */
    public static List<String> getParamStr(String message, String prefix) {
        return getParamStr(message, prefix, ",");
    }

}
