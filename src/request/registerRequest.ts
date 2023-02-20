import {GetFantastyUserParam, RegisterParam} from "@/entity/param/registerParam";
import {getInstance} from "@/conf/axiosClient";

const axiosClient = getInstance("register");

/**
 * 登录
 * @param {object} param 登录请求对象
 * @param {string} param.password 密码
 * @param {string} param.username 用户名
 * @returns
 */
export const login = function (param: RegisterParam) {
    return axiosClient({
        url: "/login",
        method: "POST",
        data: param
    });
}

/**
 * 获取联想用户
 * @param {string} param.keyword 关键词
 * @returns
 */
export const getFantasyUser = function (param: GetFantastyUserParam) {
    return axiosClient({
        url: "/getFantastyUser",
        method: "GET",
        data: param
    })
}