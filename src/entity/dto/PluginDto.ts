/**
 * 获取插件vo
 */
import {GetPluginVo} from "@/entity/vo/pluginVo";

export interface PluginShowDto extends GetPluginVo {
    showName: string;
    showStatus: string;
    showRowId: string;
}