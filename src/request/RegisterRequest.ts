import axiosClient from "@/conf/axiosClient";
import {LoginParam} from "@/entity/loginEntity";

/**
 * 登录
 * @param {object} param 登录请求对象
 * @param {string} param.password 密码
 * @param {string} param.username 用户名
 * @returns
 */
export const login = function (param: LoginParam) {
    return axiosClient({
        url: "/register/login",
        method: "POST",
        data: param
    });
}
