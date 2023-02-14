package com.dasoops.dasserver.cq;

import com.dasoops.dasserver.cq.entity.dbo.PluginDo;

/**
 * @title: IPluginRecordSaver
 * @classPath com.dasoops.dasserver.cq.IPluginRecordSaver
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/26
 * @version 1.0.0
 * @description pluginDo保存
 */
public interface IPluginRecordSaver {

    /**
     * 设置记录
     *
     * @param pluginDo 插件
     */
    void setPluginDo(PluginDo pluginDo);

    /**
     * 获取记录
     *
     * @return {@link PluginDo}
     */
    PluginDo getPluginDo();
}
