import {BaseVo} from "@/entity/vo/BaseVo";

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