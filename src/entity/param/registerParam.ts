import {BaseParam} from "@/entity/param/BaseParam";

export interface FormData {
    username: string,
    password: string,
}

export class LoginData {
    formData: FormData = {
        username: "",
        password: "",
    }
}

/**
 * 获取联想用户Param
 */
export interface GetFantastyUserParam extends BaseParam {
    keyword: string;
}

/**
 * 登录请求参数
 */
export interface RegisterParam {
    username: string,
    password: string,
}

/**
 * 登录响应参数
 */
export interface LoginRes {
    code: number;
    data: {
        token: string;
        registerId: number;
        name: string;
    };
    msg: string;
}