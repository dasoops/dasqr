import {RegisterParam} from "@/entity/param/RegisterParam";
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
