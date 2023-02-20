import {getInstance} from "@/conf/axiosClient";
import {PageResult, Result, SimpleResult} from "@/entity/result/BaseResult";
import {AddReplyParam, EditReplyParam, GetReplyPageParam} from "@/entity/param/replyParam";
import {DeleteParam} from "@/entity/param/BaseParam";
import {GetNextRowIdVo} from "@/entity/vo/BaseVo";
import {GetReplyPageVo} from "@/entity/vo/replyVo";
import {AxiosResponse} from "axios/index";

const axiosClient = getInstance('reply');

/**
 * 新增插件
 */
export const addReply = function (param: AddReplyParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/addReply",
        method: "POST",
        data: param
    })
}

/**
 * 删除回复
 */
export const deleteReply = function (param: DeleteParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/deleteReply",
        method: "POST",
        data: param,
    })
}

/**
 * 编辑回复
 */
export const editReply = function (param: EditReplyParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/editReply",
        method: "POST",
        data: param,
    })
}

/**
 * 导出
 */
export const exportAllReply = function (): Promise<AxiosResponse> {
    return axiosClient({
        url: "/exportAllReply",
        method: "GET",
        responseType: "blob"
    })
}

/**
 * 获取下一个自增主键id
 */
export const getNextReplyId = function (): Promise<Result<GetNextRowIdVo>> {
    return axiosClient({
        url: "/getNextId",
        method: "GET",
    })
}

/**
 * 获取分页回复信息
 */
export const getReplyPage = function (param: GetReplyPageParam): Promise<PageResult<GetReplyPageVo>> {
    return axiosClient({
        url: "/getReplyPage",
        method: "GET",
        data: param,
    })
}