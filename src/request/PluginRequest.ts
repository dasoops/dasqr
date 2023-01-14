import {getInstance} from "@/conf/axiosClient";
import {PageResult, Result, SimpleResult} from "@/entity/result/BaseResult";
import {AxiosResponse} from "axios";
import {
    AddPluginParam,
    CheckPluginClassPathParam,
    EditPluginParam,
    GetPluginPageSortParam, SortPluginParam
} from "@/entity/param/PluginParam";
import {DeleteParam} from "@/entity/param/BaseParam";
import {GetPluginSortVo, GetPluginVo} from "@/entity/vo/PluginVo";

const axiosClient = getInstance('plugin');

/**
 * 新增插件
 */
export const addPlugin = function (param: AddPluginParam): Promise<AxiosResponse<PageResult<AddPluginParam>>> {
    return axiosClient({
        url: "/addPlugin",
        method: "POST",
        data: param
    })
}

/**
 * 检查插件类路径
 */
export const checkPluginClassPath = function (param: CheckPluginClassPathParam): Promise<AxiosResponse<SimpleResult>> {
    return axiosClient({
        url: "/checkPluginClassPath",
        method: "GET",
        data: param
    })
}

/**
 * 删除插件
 */
export const deletePlugin = function (param: DeleteParam): Promise<AxiosResponse<SimpleResult>> {
    return axiosClient({
        url: "/deletePlugin",
        method: "POST",
        data: param
    })
}

/**
 * 编辑插件
 */
export const editPlugin = function (param: EditPluginParam): Promise<AxiosResponse<SimpleResult>> {
    return axiosClient({
        url: "/editPlugin",
        method: "POST",
        data: param,
    })
}

/**
 * 获取分页排序插件信息
 */
export const getPluginPage =  function (param: GetPluginPageSortParam): Promise<PageResult<GetPluginVo>> {
    return axiosClient({
        url: "/getPluginPage",
        method: "GET",
        data: param,
    })
}

/**
 * 获取插件排序
 */
export const getPluginSort = function (): Promise<AxiosResponse<Result<GetPluginSortVo>>> {
    return axiosClient({
        url: "/getPluginSort",
        method: "GenericTypeAnnotation",
    })
}

/**
 * 获取下一个自增主键id
 * @returns
 */
export const getNextPluginId = function (): Promise<AxiosResponse<Result<GetNextRowIdVo>>> {
    return axiosClient({
        url: "/getNextId",
        method: "GET"
    })
}

/**
 * 对插件排序
 */
export const sortPlugin = function (param: SortPluginParam): Promise<AxiosResponse<SimpleResult>> {
    return axiosClient({
        url: "/sortPlugin",
        method: "POST",
        data: param
    })
}


/**
 * 导出所有插件信息
 * @returns
 */
export const exportAllPlugin = function (): Promise<AxiosResponse> {
    return axiosClient({
        url: "/exportAllPlugin",
        method: "GET",
        responseType: "blob"
    })
}