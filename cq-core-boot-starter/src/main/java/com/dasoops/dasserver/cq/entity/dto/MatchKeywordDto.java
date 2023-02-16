package com.dasoops.dasserver.cq.entity.dto;

import com.dasoops.common.entity.dto.base.BaseDto;
import com.dasoops.dasserver.cq.entity.enums.MessageMatchTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title MatchKeywordDto
 * @classPath com.dasoops.dasserver.cq.entity.dto.MatchKeywordDto
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/20
 * @version 1.0.0
 * @description 匹配关键字dto
 * @see BaseDto
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MatchKeywordDto extends BaseDto {

    /**
     * 匹配类型
     */
    private MessageMatchTypeEnum matchType;

    /**
     * 匹配关键字
     */
    private String matchKeyword;

    /**
     * 处理关键字(包含at,供CqCode解析使用)
     */
    private String resloveKeyword;

    private MatchKeywordDto(MessageMatchTypeEnum matchType, String matchKeyword) {
        this.matchType = matchType;
        this.matchKeyword = matchKeyword;
    }

    private MatchKeywordDto(MessageMatchTypeEnum matchType, String matchKeyword, String resloveKeyword) {
        this.matchType = matchType;
        this.matchKeyword = matchKeyword;
        this.resloveKeyword = resloveKeyword;
    }

    public static MatchKeywordDto none() {
        return new MatchKeywordDto(MessageMatchTypeEnum.NONE, null);
    }

    public static MatchKeywordDto matchAll() {
        return new MatchKeywordDto(MessageMatchTypeEnum.MATCH_ALL, null);
    }

    public static MatchKeywordDto prefix(String keyword, String resloveKeyword) {
        return new MatchKeywordDto(MessageMatchTypeEnum.PREFIX, keyword, resloveKeyword);
    }

    public static MatchKeywordDto suffix(String keyword) {
        return new MatchKeywordDto(MessageMatchTypeEnum.PREFIX, keyword);
    }

    public static MatchKeywordDto equal(String keyword) {
        return new MatchKeywordDto(MessageMatchTypeEnum.PREFIX, keyword);
    }

    public static MatchKeywordDto contain(String keyword) {
        return new MatchKeywordDto(MessageMatchTypeEnum.PREFIX, keyword);
    }
}
