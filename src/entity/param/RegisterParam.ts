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
    };
    msg: string;
}