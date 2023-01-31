import {BaseEditParam, BaseParam, PageParam} from "@/entity/param/baseParam";

/**
 * 添加回复param
 */
export interface AddReplyParam extends BaseParam {
    enable: number;
    ignoreCase: number;
    ignoreDbc: number;
    keyword: string;
    matchType: number;
    reply: string;
}

/**
 * 编辑回复param
 */
export interface EditReplyParam extends BaseEditParam {
    enable: number;
    ignoreCase: number;
    ignoreDbc: number;
    keyword: string;
    matchType: number;
    reply: string;
}

/**
 * 获取回复页面param
 */
export interface GetReplyPageParam extends PageParam {
    matchTypeList?: number[];
    matchKeyword?: string;
}
