import {AxiosResponse} from "axios";

/**
 * 简单导出
 * @param res void
 */
export function simpleExport(res: AxiosResponse) {
    const data = res.data;
    if (!data) {
        return
    }

    const url = window.URL.createObjectURL(new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"}))
    const a = document.createElement('a')
    a.style.display = 'none'
    a.href = url

    //文件名
    const rawFileName = res.headers['content-disposition'];
    if (!rawFileName) {
        return;
    }
    const fileName = getFileNameForDisposition(rawFileName);
    a.setAttribute('download', fileName)

    document.body.appendChild(a)
    a.click()
    window.URL.revokeObjectURL(a.href)
    document.body.removeChild(a)
}

/**
 * 从请求头Content-disposition中获取文件名
 * @param disposition
 */
export function getFileNameForDisposition(disposition: string) {
    let tempStr = disposition.substring(disposition.lastIndexOf('filename'))
    if (!tempStr) {
        return "default";
    }
    tempStr = tempStr.replace("filename_=utf-8''", "");
    tempStr = tempStr.replace("filename*=utf-8''", "");
    tempStr = tempStr.replace("filename*=", "");
    tempStr = tempStr.replace("filename=", "");
    return tempStr;
}