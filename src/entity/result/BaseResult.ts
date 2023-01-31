/**
 * Result基类
 */
import {BaseVo} from "@/entity/vo/baseVo";

export interface BaseResult {
    code: number;
    msg: string;
}

/**
 * Result
 */
export interface Result<T extends BaseVo> extends BaseResult {
    data: T;
}

/**
 * 分页Result
 */
export interface PageResult<T extends BaseVo> extends BaseResult {
    total: number;
    data: T[];
}

/**
 * 简单Result
 */
export type SimpleResult = BaseResult