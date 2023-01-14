/**
 * 获取插件vo
 */
export interface GetPluginVo extends BaseVo {
    name: string;
    description: string;
    classPath: string;
    order: number;
    level: number;
    enable: number;
    rowId: number;
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