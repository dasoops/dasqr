/**
 * Result基类
 */
export interface BaseResult<T> {
    code: number;
    data: T;
    msg: string;
}

/**
 * Result
 */
// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface Result<T> extends BaseResult<T> {

}

/**
 * 分页Result
 */
export interface PageResult<T> extends Result<T> {
    total: number;
}

/**
 * Param基类
 */
// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface BaseParam {

}

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