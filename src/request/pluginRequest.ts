import {getInstance} from "@/conf/axiosClient";
import {PageResult, Result, SimpleResult} from "@/entity/result/BaseResult";
import {AxiosResponse} from "axios";
import {
    AddPluginParam,
    CheckPluginClassPathParam,
    EditPluginParam,
    GetPluginPageSortParam,
    SortPluginParam
} from "@/entity/param/pluginParam";
import {DeleteParam} from "@/entity/param/BaseParam";
import {GetRegisterRouteKeywordVo, GetPluginSortVo, GetPluginVo} from "@/entity/vo/pluginVo";
import {GetNextRowIdVo} from "@/entity/vo/BaseVo";

const axiosClient = getInstance('plugin');

/**
 * 新增插件
 */
export const addPlugin = function (param: AddPluginParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/addPlugin",
        method: "POST",
        data: param
    })
}

/**
 * 检查插件类路径
 */
export const checkPluginClassPathNoError = function (param: CheckPluginClassPathParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/checkPluginClassPath",
        method: "GET",
        data: param,
        passError: true
    })
}

/**
 * 检查插件类路径
 */
export const checkPluginClassPath = function (param: CheckPluginClassPathParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/checkPluginClassPath",
        method: "GET",
        data: param
    })
}

/**
 * 删除插件
 */
export const deletePlugin = function (param: DeleteParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/deletePlugin",
        method: "POST",
        data: param
    })
}

/**
 * 编辑插件
 */
export const editPlugin = function (param: EditPluginParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/editPlugin",
        method: "POST",
        data: param,
    })
}

/**
 * 获取分页排序插件信息
 */
export const getPluginPage = function (param: GetPluginPageSortParam): Promise<PageResult<GetPluginVo>> {
    return axiosClient({
        url: "/getPluginPage",
        method: "POST",
        data: param,
    })
}

/**
 * 获取插件排序
 */
export const getPluginSort = function (): Promise<Result<GetPluginSortVo>> {
    return axiosClient({
        url: "/getPluginSort",
        method: "GET",
    })
}

/**
 * 获取下一个自增主键id
 * @returns
 */
export const getNextPluginId = function (): Promise<Result<GetNextRowIdVo>> {
    return axiosClient({
        url: "/getNextId",
        method: "GET"
    })
}

/**
 * 对插件排序
 */
export const sortPlugin = function (param: SortPluginParam): Promise<SimpleResult> {
    return axiosClient({
        url: "/sortPlugin",
        method: "POST",
        data: param
    })
}

/**
 * 导出所有插件信息
 */
export const exportAllPlugin = function (): Promise<any> {
    return axiosClient({
        url: "/exportAllPlugin",
        method: "GET",
        responseType: "blob"
    })
}

/**
 * 获取注册路由关键词集合
 */
export const getRegisterRouteKeywordList = function (): Promise<Result<GetRegisterRouteKeywordVo>> {
    return axiosClient({
        url: "/getRegisterRouteKeywordList",
        method: "GET",
    })
}