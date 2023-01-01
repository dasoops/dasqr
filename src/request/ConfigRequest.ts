import {AddConfigParam, EditConfigParam, GetConfigParam} from "@/entity/configModel";
import axiosClient from "@/conf/axiosClient";

/**
 * 获取分页配置信息
 * @param getConfigParam
 */
export const getConfigPage = function (getConfigParam: GetConfigParam) {
    return axiosClient({
        url: "/config/getConfigPage",
        method: "GET",
        params: getConfigParam
    })
}

/**
 * 编辑配置
 * @param editConfigParam
 */
export const editConfig = function (editConfigParam: EditConfigParam) {
    return axiosClient({
        url: "/config/editConfig",
        method: "POST",
        data: editConfigParam
    });
}

/**
 * 获取下一个自增主键id
 */
export const getNextConfigId = function () {
    return axiosClient({
        url: "/config/getNextId",
        method: "GET"
    });
}

/**
 * 新增配置
 * @param addConfigParam
 */
export const addConfig = function (addConfigParam: AddConfigParam) {
    return axiosClient({
        url: "/config/addConfig",
        method: "POST",
        data: addConfigParam
    });
}

/**
 * 删除配置
 * @param id
 */
export const deleteConfig = function (id: number) {
    return axiosClient({
        url: "/config/deleteConfig",
        method: "POST",
        data: {"id": id}
    });
}

/**
 * 导出所有配置
 */
export const exportAllConfig = function () {
    return axiosClient({
        url: "/config/exportAllConfig",
        method: "GET",
        responseType: "blob"
    })
}