/**
 * 编辑图片信息Param
 */
import {BaseParam, PageParam} from "@/entity/BaseEntity";

export interface EditImageInfoParam extends BaseParam {
    fileName: string;
    id: number;
    keyword: string;
}

/**
 * 添加图片Param
 */
export interface AddImageParam extends BaseParam {
    fileName: string;
    keyword: string;
}

/**
 * 删除图片Param
 */
export interface DeleteImageParam extends BaseParam {
    id: number;
}

/**
 * 获取联想关键词Param
 */
export interface GetFantasyKeywordParam extends BaseParam {
    keyword: string;
}

/**
 * 获取联想用户Param
 */
export interface GetFantastyUserParam extends BaseParam {
    keyword: string;
}

/**
 * 获取分页图像信息Param
 */
export interface GetImageInfoPageParam extends PageParam {
    keyword?: number;
    createUser?: number;
}

/**
 * 图片表格信息
 */
export interface ImageData {
    id: number;
    keyword: string;
    filePath: string;
    groupId: number;
    authorId: number;
    author: string;
    authorName: string;
    updateTime: string;
    fileName: string;
}

/**
 * 上传图片Result
 */
export interface UploadImageRes {
    fileName: string,
    filePath: string,
}

/**
 * 联想用户
 */
export interface FantastyUserRes {
    registerId: number;
    name: string;
}