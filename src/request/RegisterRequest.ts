import axiosClient from "@/conf/axiosClient";
import {LoginParam} from "@/entity/loginModel";

/**
 * 登录
 * @param loginParam
 */
export const login = function (loginParam: LoginParam) {
    return axiosClient({
        url: "/register/login",
        method: "POST",
        data: loginParam
    });
}
