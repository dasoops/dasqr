import axiosClient from "@/conf/axiosClient";
import {
    AddImageParam,
    DeleteImageParam,
    EditImageInfoParam, GetFantastyUserParam,
    GetFantasyKeywordParam,
    GetImageInfoPageParam
} from "@/entity/ImageEntity";
import {getBaseUrl} from "@/request/initRequest";

/**
 * 获取分页配置信息
 * @param param
 */
export const getImagePage = function (param: GetImageInfoPageParam) {
    return axiosClient({
        url: "/config/getConfigPage",
        method: "GET",
        params: param
    })
}

/**
 * 编辑图片信息
 * @param {object} param 编辑图片参数
 * @param {string} param.fileName 图片名称
 * @param {number} param.id id
 * @param {string} param.keyword 图片关键词
 * @returns
 */
export const editImageInfo = function (param: EditImageInfoParam) {
    return axiosClient({
        url: "/image/editImageInfo",
        method: "POST",
        data: param
    })
}

/**
 * 新增图片
 * @param {object} param 添加图片param
 * @param {string} param.fileName 图片名称
 * @param {string} param.keyword 关键词
 * @returns
 */
export const addImage = function (param: AddImageParam) {
    return axiosClient({
        url: "/image/addImage",
        method: "POST",
        data: param
    })
}

/**
 * 删除图片
 * @param {object} param 删除图片param
 * @param {number} param.id id
 * @returns
 */
export const deleteImage = function (param: DeleteImageParam) {
    return axiosClient({
        url: "/image/deleteImage",
        method: "POST",
        data: param
    })
}

/**
 * 导出所有图片信息
 * @returns
 */
export const exportAllImageInfo = function () {
    return axiosClient({
        url: "/image/exportAllImageInfo",
        method: "GET",
        responseType: "blob"
    })
}

/**
 * 获取联想关键词
 * @param {string} param.keyword 关键词
 * @returns
 */
export const getFantastyKeyword = function (param: GetFantasyKeywordParam) {
    return axiosClient({
        url: "/image/getFantastyKeyword",
        method: "GET",
        params: param
    })
}

/**
 * 获取联想用户
 * @param {string} param.keyword 关键词
 * @returns
 */
export const getFantasyUser = function (param: GetFantastyUserParam) {
    return axiosClient({
        url: "/image/getFantastyUser",
        method: "GET",
        params: param
    })
}

/**
 * 获取图片信息
 * @param {string} param.beginTime 开始时间
 * @param {string} param.createUser 创建用户
 * @param {string} param.current 当前页码
 * @param {string} param.endTime 结束时间
 * @param {string} param.keyword 关键词
 * @param {string} param.size 每页显示数量
 * @param {string} param.total 总记录数
 * @returns
 */
export const getImageInfoPage = function (param: GetImageInfoPageParam) {
    return axiosClient({
        url: "/image/getImageInfoPage",
        method: "GET",
        params: param
    })
}

/**
 * 获取下一个自增主键id
 * @returns
 */
export const getNextId = function () {
    return axiosClient({
        url: "/image/getNextId",
        method: "GET"
    })
}

export const uploadImageUrl = getBaseUrl() + "/image/uploadImage";
export const uploadImageMethod = "POST";