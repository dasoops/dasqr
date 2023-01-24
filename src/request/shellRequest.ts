import {getInstance} from "@/conf/axiosClient";
import {Result} from "@/entity/result/BaseResult";
import {GetWsUrlVo} from "@/entity/vo/shellVo";

const axiosClient = getInstance("shell");

/**
 * 获取wsUrl
 */
export const getWsUrl = function (): Promise<Result<GetWsUrlVo>> {
    return axiosClient({
        url: "/getWsUrl",
        method: "GET"
    });
}
