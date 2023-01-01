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