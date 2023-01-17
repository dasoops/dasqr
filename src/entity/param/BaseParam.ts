

/**
 * Param基类
 */
// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface BaseParam {

}

/**
 * 排序param
 */
export interface SortParam {
    sortColumn: number;
    sortRule: number;
}

/**
 * 编辑和删除Param基类
 */
export interface BaseDeleteAndEditParam extends BaseParam {
    rowId: number;
}

/**
 * 编辑和删除Param基类
 */
export type DeleteParam = BaseDeleteAndEditParam

/**
 * 分页Param
 */
export interface PageParam extends BaseParam {
    current: number;
    size: number;
}

/**
 * 时间Param
 */
export interface TimeParam extends BaseParam {
    beginTime?: string;
    endTime?: string;
}

/**
 * 分页时间Param
 */
export interface TimePageParam extends PageParam, TimeParam {

}