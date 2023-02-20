import {
    AddImageParam,
    DeleteImageParam,
    EditImageInfoParam,
    GetFantasyKeywordParam,
    GetImageInfoPageParam
} from "@/entity/param/imageParam";
import {getInstance} from "@/conf/axiosClient";
import {getBaseUrl} from "@/conf/application";

const axiosClient = getInstance("image");

/**
 * 获取分页配置信息
 * @param param
 */
export const getImagePage = function (param: GetImageInfoPageParam) {
    return axiosClient({
        url: "/getImagePage",
        method: "GET",
        data: param
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
        url: "/editImageInfo",
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
        url: "/addImage",
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
        url: "/deleteImage",
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
        url: "/exportAllImageInfo",
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
        url: "/getFantastyKeyword",
        method: "GET",
        data: param
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
        url: "/getImageInfoPage",
        method: "GET",
        data: param
    })
}

/**
 * 获取下一个自增主键id
 * @returns
 */
export const getNextImageId = function () {
    return axiosClient({
        url: "/getNextId",
        method: "GET"
    })
}

export const uploadImageUrl = getBaseUrl() + "/image/uploadImage";
export const uploadImageMethod = "POST";