import {BaseDeleteAndEditParam, BaseParam, PageParam, SortParam} from "@/entity/param/baseParam";

/**
 * 获取插件排序分页信息param
 */
export interface GetPluginPageSortParam extends PageParam {
    sortParamList?: SortParam[];
    statusList: number[];
}

/**
 * 编辑插件param
 */
export interface EditPluginParam extends BaseDeleteAndEditParam {
    classPath: string;
    description: string;
    enable: number;
    level: number;
    name: string;
}

/**
 * 添加插件param
 */
export interface AddPluginParam extends BaseParam {
    classPath: string;
    description: string;
    enable: number;
    level: number;
    name: string;
}

/**
 * 插件排序param
 */
export interface SortPluginParam extends BaseParam {
    sortPluginList: SortPluginInnerParam[];
}

/**
 * 插件排序中间aram
 */
export interface SortPluginInnerParam {
    rowId: number;
    order: number;
}

/**
 * 检查插件类路径
 */
export interface CheckPluginClassPathParam {
    classPath: string;
    checkRepeatClassPath: number;
}
