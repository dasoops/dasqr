/**
 * 配置数据
 */
import {BaseParam, PageParam} from "@/entity/BaseEntity";

export interface ConfigData {
    id: number;
    keyword: string;
    value: string;
    description: string;
}

/**
 * 获取分页配置数据参数
 */
export interface GetConfigPageParam extends PageParam {
    keyword?: string;
    description?: string;
}

/**
 * 编辑配置参数
 */
export interface EditConfigParam extends BaseParam {
    description?: string;
    id: number;
    keyword?: string;
    value?: string;
}

/**
 * 新增配置参数
 */
export interface AddConfigParam extends BaseParam {
    keyword: string;
    value: string;
    description: string;
    canEdit?: number;
}

/**
 * 删除配置参数
 */
export interface DeleteConfigParam extends BaseParam {
    id: number;
}