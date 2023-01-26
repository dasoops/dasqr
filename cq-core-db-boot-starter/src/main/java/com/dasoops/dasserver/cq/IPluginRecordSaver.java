package com.dasoops.dasserver.cq;

import com.dasoops.dasserver.cq.entity.dbo.PluginDo;

/**
 * @Title: IPluginRecordSaver
 * @ClassPath com.dasoops.dasserver.cq.IPluginRecordSaver
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/26
 * @Version 1.0.0
 * @Description: pluginDo保存
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
