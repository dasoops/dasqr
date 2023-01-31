import {AddConfigParam, DeleteConfigParam, EditConfigParam, GetConfigPageParam} from "@/entity/param/configParam";
import {getInstance} from "@/conf/axiosClient";

const axiosClient = getInstance("config");

/**
 * 获取分页配置信息
 * @param {string} param.current 当前页码
 * @param {string} param.description 描述
 * @param {string} param.keyword 关键字
 * @param {string} param.size 每页显示数量
 * @returns
 */
export const getConfigPage = function (param: GetConfigPageParam) {
    return axiosClient({
        url: "/getConfigPage",
        method: "GET",
        data: param
    })
}

/**
 * 编辑配置
 * @param {object} param 编辑配置参数
 * @param {string} param.description 描述
 * @param {number} param.id id
 * @param {string} param.keyword 配置项关键词
 * @param {string} param.value 配置项属性值
 * @returns
 */
export const editConfig = function (param: EditConfigParam) {
    return axiosClient({
        url: "/editConfig",
        method: "POST",
        data: param
    });
}

/**
 * 获取下一个自增主键id
 * @returns
 */
export const getNextConfigId = function () {
    return axiosClient({
        url: "/getNextId",
        method: "GET"
    });
}

/**
 * 新增配置
 * @param {object} param param
 * @param {number} param.canEdit 是否支持编辑,可用值:0,1
 * @param {string} param.description 描述
 * @param {string} param.keyword 配置项关键词
 * @param {string} param.value 配置项属性值
 * @returns
 */
export const addConfig = function (param: AddConfigParam) {
    return axiosClient({
        url: "/addConfig",
        method: "POST",
        data: param
    });
}

/**
 * 删除配置
 * @param {object} param 删除配置参数
 * @param {number} param.id id
 * @returns
 */
export const deleteConfig = function (param: DeleteConfigParam) {
    return axiosClient({
        url: "/deleteConfig",
        method: "POST",
        data: param
    });
}

/**
 * 导出所有配置
 * @returns
 */
export const exportAllConfig = function () {
    return axiosClient({
        url: "/exportAllConfig",
        method: "GET",
        responseType: "blob"
    })
}