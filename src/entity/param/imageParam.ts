import {BaseDeleteAndEditParam, BaseParam, PageParam} from "@/entity/param/BaseParam";

/**
 * @Title: CodeGenerateServiceImpl
 * @ClassPath com.dasoops.dasserver.plugin.code.generate.ts.service.impl.CodeGenerateServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/02/15
 * @Version 1.0.0
 * @Description: 编号生成服务impl
 * @see [CodeGenerateServiceImpl]
 */

/**
 * 编辑图片信息Param
 */
export interface EditImageInfoParam extends BaseDeleteAndEditParam {
    fileName: string;
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
    rowId: number;
}

/**
 * 获取联想关键词Param
 */
export interface GetFantasyKeywordParam extends BaseParam {
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
    rowId: number;
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