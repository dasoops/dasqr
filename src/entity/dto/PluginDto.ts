/**
 * 获取插件vo
 */
import {GetPluginVo} from "@/entity/vo/PluginVo";

export interface PluginShowDto extends GetPluginVo {
    showName: string;
    showStatus: string;
    showRowId: string;
}