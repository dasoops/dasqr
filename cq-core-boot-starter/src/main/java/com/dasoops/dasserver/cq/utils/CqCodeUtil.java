package com.dasoops.dasserver.cq.utils;

import cn.hutool.core.util.EnumUtil;
import cn.hutool.core.util.ReUtil;
import com.dasoops.dasserver.cq.entity.dto.cq.CqCode;
import com.dasoops.dasserver.cq.entity.enums.CqCodeTypeEnum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @title CqCodeUtil
 * @classPath com.dasoops.dasserver.cq.utils.CqCodeUtil
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cq编号跑龙套
 */
public class CqCodeUtil {

    /**
     * 反转义
     *
     * @param str str
     * @return {@link String}
     */
    public static String unescape(String str) {
        return str.replace("&#44;", ",")
                .replace("&#91;", "[")
                .replace("&#93;", "]")
                .replace("&amp;", "&");
    }

    /**
     * 转义
     *
     * @param str str
     * @return {@link String}
     */
    public static String escape(String str) {
        return str.replace(",", "&#44;")
                .replace("[", "&#91;")
                .replace("]", "&#93;")
                .replace("&", "&amp;");
    }

    public static boolean haveCqCode(String message) {
        String regex = "\\[CQ:\\w+?.*?]";
        return ReUtil.contains(regex, message);
    }

    public static Optional<List<String>> getCqCode(String message) {
        if (!haveCqCode(message)) {
            return Optional.empty();
        }

        final String codeRegex = "\\[CQ:\\w+?.*?]";
        List<String> cqCodeStrList = ReUtil.findAll(codeRegex, message, 0, new ArrayList<>());
        return Optional.of(cqCodeStrList);
    }

    public static Optional<List<CqCode>> reslove(String message) {
        //获取cqCode
        Optional<List<String>> cqCodeStrListOpt = getCqCode(message);
        if (cqCodeStrListOpt.isEmpty()) {
            return Optional.empty();
        }
        List<String> cqCodeStrList = cqCodeStrListOpt.get();

        final String typeRegex = "\\[CQ:(\\w+)";
        final String paramRegex = ",([\\w\\-.]+?)=([^,\\]]+)";
        List<CqCode> cqCodeList = cqCodeStrList.stream().map(cqCodeStr -> {
            CqCode cqCode = new CqCode();

            //获取类型
            String typeStr = ReUtil.findAll(typeRegex, cqCodeStr, 0, new ArrayList<>()).get(0);
            cqCode.setTypeEnum(EnumUtil.getBy(CqCodeTypeEnum::getStringValue, typeStr.replace("[CQ:", "")));

            //获取参数集合
            List<String> paramStrList = ReUtil.findAll(paramRegex, cqCodeStr, 0, new ArrayList<>());
            Map<String, String> paramMap = new HashMap<>(4);
            paramStrList.forEach(paramStr -> {
                String key = paramStr.substring(1, paramStr.indexOf("="));
                String value = paramStr.substring(paramStr.indexOf("=") + 1);
                paramMap.put(key, value);
            });
            cqCode.setParam(paramMap);
            return cqCode;
        }).collect(Collectors.toList());

        return Optional.of(cqCodeList);
    }

    /**
     * 构建cqCode
     *
     * @param typeEnum 枚举类型
     * @return {@link String}
     */
    public static String buildCqCode(CqCodeTypeEnum typeEnum) {
        String sb = "[CQ:" + typeEnum.getStringValue() + "]";
        return sb;
    }

    /**
     * 构建cqCode
     *
     * @param typeEnum 类型
     * @param params   参数个数
     * @return {@link String}
     */
    public static String buildCqCode(CqCodeTypeEnum typeEnum, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("[CQ:").append(typeEnum.getStringValue());
        params.forEach((key, value) -> sb.append(",").append(key).append("=").append(escape(String.valueOf(value))));
        sb.append("]");
        return sb.toString();
    }

    /**
     * 系统表情
     *
     * @param id 为≥0的数字
     * @return [CQ:face,id=14]（发送一个微笑的系统表情）
     */
    public static String face(int id) {
        return buildCqCode(CqCodeTypeEnum.FACE, Map.of("id", id));
    }

    /**
     * emoji表情
     * id表 https://cqp.cc/t/15827
     *
     * @param id emoji字符的unicode编号
     * @return [CQ:emoji,id=128513]（发送一个大笑的emoji表情）
     */
    public static String emoji(int id) {
        return buildCqCode(CqCodeTypeEnum.EMOJI, Map.of("id", id));
    }

    /**
     * 原创表情
     *
     * @param id 该原创表情的ID，存放在酷Q目录的data\bface\下
     * @return [CQ:bface,id={1}]
     */
    public static String bface(int id) {
        return buildCqCode(CqCodeTypeEnum.BFACE, Map.of("id", id));
    }

    /**
     * 小表情
     *
     * @param id 该小表情的ID
     * @return [CQ:sface,id={1}]
     */
    public static String sface(int id) {
        return buildCqCode(CqCodeTypeEnum.SFACE, Map.of("id", id));
    }

    /**
     * 自定义图片
     *
     * @param file 图片文件名称，图片存放在酷Q目录的data\image\下
     * @return [CQ:image,file={1}]
     */
    public static String image(String file) {
        return buildCqCode(CqCodeTypeEnum.IMAGE, Map.of("file", file));
    }


    /**
     * 自定义图片
     *
     * @param file    图片文件名称，图片存放在酷Q目录的data\image\下
     * @param cache   是否缓存
     * @param timeout 下载操作超时(单位秒)
     * @return [CQ:image,file={1},cache={2},timeout={3}]
     */
    public static String image(String file, boolean cache, int timeout) {
        return buildCqCode(CqCodeTypeEnum.IMAGE, Map.of("file", file, "cache", cache, "timeout", timeout));
    }


    /**
     * 语音
     *
     * @param file  音频文件名称，音频存放在酷Q目录的data\record\下
     * @param magic 是否为变声，若该参数为true则显示变声标记。该参数可被忽略。
     * @return [CQ:record,file={1},magic={2},cache={2},timeout={3}]
     */
    public static String record(String file, boolean magic) {
        return buildCqCode(CqCodeTypeEnum.RECORD, Map.of("file", file, "magic", magic));
    }

    /**
     * 语音
     *
     * @param file    音频文件名称，音频存放在酷Q目录的data\record\下
     * @param magic   是否为变声，若该参数为true则显示变声标记。该参数可被忽略。
     * @param cache   是否缓存
     * @param timeout 下载操作超时(单位秒)
     * @return
     */
    public static String record(String file, boolean magic, boolean cache, int timeout) {
        return buildCqCode(CqCodeTypeEnum.RECORD, Map.of("file", file, "magic", magic, "cache", cache, "timeout", timeout));
    }

    /**
     * at某人
     *
     * @param qq 被@的群成员帐号
     * @return [CQ:at,qq={1}]
     */
    public static String at(Long qq) {
        return buildCqCode(CqCodeTypeEnum.AT, Map.of("qq", qq));
    }

    /**
     * at全体成员
     *
     * @return [CQ:at,qq=all]
     */
    public static String atAll() {
        return buildCqCode(CqCodeTypeEnum.AT, Map.of("qq", "all"));
    }

    /**
     * 猜拳魔法表情
     *
     * @param type 为猜拳结果的类型，暂不支持发送时自定义
     * @return [CQ:rps,type={1}]
     */
    public static String rps(int type) {
        return buildCqCode(CqCodeTypeEnum.RPS, Map.of("type", type));
    }

    /**
     * 掷骰子魔法表情
     *
     * @param type 对应掷出的点数，暂不支持发送时自定义
     * @return [CQ:dice,type={1}]
     */
    public static String dice(int type) {
        return buildCqCode(CqCodeTypeEnum.DICE, Map.of("type", type));
    }

    /**
     * 戳一戳
     * 仅支持好友消息使用
     *
     * @return [CQ:shake]
     */
    public static String shake() {
        return buildCqCode(CqCodeTypeEnum.SHAKE);
    }

    /**
     * 匿名发消息
     * 本CQ码需加在消息的开头。仅支持群消息使用。
     *
     * @param ignore 为 true 时，代表不强制使用匿名，如果匿名失败将转为普通消息发送。为 false 时，代表强制使用匿名，如果匿名失败将取消该消息的发送。
     * @return [CQ:anonymous,ignore=true]
     */
    public static String anonymous(boolean ignore) {
        return buildCqCode(CqCodeTypeEnum.ANONYMOUS, Map.of("ignore", ignore));
    }

    /**
     * 地点
     *
     * @param lat     纬度
     * @param lon     经度
     * @param title   分享地点的名称
     * @param content 分享地点的具体地址
     * @return [CQ:location,lat=39.918056,lon=116.397027,title=故宫博物院,content=北京市东城区景山前街4号]
     */
    public static String location(double lat, double lon, String title, String content) {
        return buildCqCode(CqCodeTypeEnum.LOCATION, Map.of("lat", lat, "lon", lon, "title", title, "content", content));
    }

    /**
     * 签到
     *
     * @param location 用户签到的地点，为中文字串
     * @param title    用户签到时发表的心情文字
     * @param image    签到卡片所使用的背景图片链接
     * @return [CQ:sign,location={1},title={2},image={3}]
     */
    public static String sign(String location, String title, String image) {
        return buildCqCode(CqCodeTypeEnum.SIGN, Map.of("location", location, "title", title, "image", image));
    }

    /**
     * 音乐
     *
     * @param type  音乐平台类型，目前支持qq、163
     * @param id    对应音乐平台的数字音乐id
     * @param style 音乐卡片的风格。仅 Pro 支持该参数，该参数可被忽略。
     * @return [CQ:music,type={1},id={2},style={3}]
     */
    public static String music(String type, int id, String style) {
        return buildCqCode(CqCodeTypeEnum.MUSIC, Map.of("type", type, "id", id, "style", style));
    }

    /**
     * 音乐自定义分享
     *
     * @param url     分享链接，即点击分享后进入的音乐页面（如歌曲介绍页）
     * @param audio   音频链接（如mp3链接）
     * @param title   音乐的标题，建议12字以内
     * @param content 音乐的简介，建议30字以内。该参数可被忽略
     * @param image   音乐的封面图片链接。若参数为空或被忽略，则显示默认图片
     * @return [CQ:music,type=custom,url={1},audio={2},title={3},content={4},image={5}]
     */
    public static String customMusic(String url, String audio, String title, String content, String image) {
        return buildCqCode(CqCodeTypeEnum.CUSTOM_MUSIC, Map.of("url", url, "audio", audio, "title", title, "content", content, "image", image));
    }

    /**
     * 链接分享
     *
     * @param url     分享链接
     * @param title   分享的标题，建议12字以内
     * @param content 分享的简介，建议30字以内。该参数可被忽略。
     * @param image   分享的图片链接。若参数为空或被忽略，则显示默认图片
     * @return [CQ:share,url={1},title={2},content={3},image={4}]
     */
    public static String share(String url, String title, String content, String image) {
        return buildCqCode(CqCodeTypeEnum.SHARE, Map.of("url", url, "title", title, "content", content, "image", image));
    }

    /**
     * 分享联系人/群
     *
     * @param id   QQ/群号
     * @param type 类型
     * @return [CQ:contact,type={1},id={2}]
     */
    public static String contact(String type, Long id) {
        return buildCqCode(CqCodeTypeEnum.CONTACT, Map.of("type", type, "id", id));
    }

    public static String getImgUrl(String param) {
        return ReUtil.getGroup0(".(?<=url=h).*?(?=])", param);
    }
}
