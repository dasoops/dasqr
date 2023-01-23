package com.dasoops.dasserver.plugin.setu.entity.param;

import com.dasoops.common.entity.param.base.BaseParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: SetuParam
 * @ClassPath com.dasoops.dasserver.plugin.shell.entity.param.SetuParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/22
 * @Version 1.0.0
 * @Description: setuparam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SetuParam extends BaseParam {

    /**
     * 0为非 R18，1为 R18，2为混合（在库中的分类，不等同于作品本身的 R18 标识）
     */
    private Integer r18;

    /**
     * 一次返回的结果数量，范围为1到20；在指定关键字或标签的情况下，结果数量可能会不足指定的数量
     */
    private Integer number;

    /**
     * 返回指定uid作者的作品，最多20个
     */
    private List<Long> uidList;

    /**
     * 返回从标题、作者、标签中按指定关键字模糊匹配的结果，大小写不敏感，性能和准度较差且功能单一，建议使用tag代替
     */
    private String keyword;

    /**
     * 返回匹配指定标签的作品
     */
    private List<String> tag;

    /**
     * 返回指定图片规格的地址
     */
    private List<String> size;

    /**
     * 设置图片地址所使用的在线反代服务
     */
    private String proxy;

    /**
     * 返回在这个时间及以后上传的作品；时间戳，单位为毫秒
     */
    private Long dateAfter;

    /**
     * 返回在这个时间及以前上传的作品；时间戳，单位为毫秒
     */
    private Long dateBefore;

    /**
     * 禁用对某些缩写keyword和tag的自动转换
     */
    private Boolean dsc;

    /**
     * 排除 AI 作品
     */
    private Boolean excludeAI;

}
