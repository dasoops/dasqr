import {getFileNameForDisposition} from "@/util/StringUtil";
import {AxiosResponse} from "axios";

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