/**
 * 获取插件vo
 */
import {BaseVo} from "@/entity/vo/BaseVo";

export interface GetPluginVo extends BaseVo {
    name: string;
    description: string;
    classPath: string;
    order: number;
    level: number;
    enable: number;
    rowId: number;
    status: number;
}

/**
 * 获取插件排序vo
 */
export interface GetPluginSortVo extends BaseVo {
    pluginSortList: PluginSortInnerVo[];
}

/**
 * 插件排序中间vo
 */
export interface PluginSortInnerVo {
    rowId: number;
    name: string;
    description: string;
    order: number;
}

/**
 * 获取注册路由关键词集合
 */
export interface GetRegisterRouteKeywordVo {
    registerRouteKeywordList: string[],
}