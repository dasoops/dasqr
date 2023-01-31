import {BaseVo} from "@/entity/vo/baseVo";

/**
 * 获取回复vo
 */
export interface GetReplyPageVo extends BaseVo {
    rowId: number;
    keyword: string;
    reply: string;
    enable: number;
    ignoreCase: number;
    ignoreDbc: number;
    matchType: number;
}