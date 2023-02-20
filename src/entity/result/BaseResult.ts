/**
 * BaseParam.ts
 * @title {title} BaseParam
 * @author {Author} DasoopsNicole@gmail.com
 * @date {Date} 2023-02-17 09:54:56
 * @description {Description} result基类文件
 */

import {BaseVo} from "@/entity/vo/BaseVo";

/**
 * Result顶层接口
 */
export interface BaseResult {
    /**
     * 返回状态码
     * 此状态码为后端内部响应状态码,不代表http请求状态
     * 收到此状态码就表示http请求成功
     *
     * 200   - 200  : 成功
     * 401   - 401  : 权限校验不通过
     * 65535 - 65535: 未预料的异常
     * 00000 - 10000: 通用异常
     * 90000 - 99999: 通用包工具类异常
     * 10000 - 20000: 业务异常
     */
    code: number;

    /**
     * 返回响应信息
     * 此信息为后端提供的错误/成功信息
     * 当状态码不为200时可将此信息展示给用户
     */
    msg: string;
}

/**
 * 通用Result
 *
 */
export interface Result<T extends BaseVo> extends BaseResult {
    /**
     * 返回结果
     */
    data: T;
}

/**
 * 简单Result
 * 无返回值,仅包含状态码与响应信息
 */
export type SimpleResult = BaseResult

/**
 * 分页Result
 */
export interface PageResult<T extends BaseVo> extends BaseResult {
    total: number;
    data: T[];
}