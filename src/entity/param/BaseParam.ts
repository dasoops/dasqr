/**
 * BaseParam.ts
 * @title {title} BaseParam
 * @author {Author} DasoopsNicole@gmail.com
 * @date {Date} 2023-02-17 09:31:13
 * @description {Description} param基类文件
 */

//no import

/**
 * Param顶层接口
 */
export interface BaseParam {

}

/**
 * 内部param标记接口
 */
export interface BaseInnerParam extends BaseParam {

}

/**
 * 分页Param
 */
export interface PageParam extends BaseParam {
    /**
     * 当前页
     */
    current: number;

    /**
     * 当前页大小
     */
    size: number;
}

/**
 * 时间Param
 */
export interface TimeParam extends BaseParam {
    /**
     * 起始时间
     */
    beginTime?: string;

    /**
     * 结束时间
     */
    endTime?: string;
}

/**
 * 分页时间Param
 */
export interface TimePageParam extends PageParam, TimeParam {

}

/**
 * 编辑和删除Param基类
 */
export interface BaseDeleteAndEditParam extends BaseParam {
    /**
     * 主键id
     */
    rowId: number;
}

/**
 * 排序param
 */
export interface SortParam extends BaseInnerParam {
    /**
     * 排序字段
     */
    sortColumn: number;

    /**
     * 排序规则(0:desc;1:asc;)
     */
    sortRule: number;
}

/**
 * 编辑Param基类
 */
export type BaseEditParam = BaseDeleteAndEditParam;

/**
 * 编辑和删除Param基类
 */
export type DeleteParam = BaseDeleteAndEditParam;