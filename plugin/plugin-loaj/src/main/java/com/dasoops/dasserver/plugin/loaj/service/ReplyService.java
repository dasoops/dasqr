package com.dasoops.dasserver.plugin.loaj.service;

import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Title: ReplyService
 * @ClassPath com.dasoops.dasserver.plugin.loaj.service.ReplyService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/11
 * @Version 1.0.0
 * @Description: 针对表【tb_plugin_loaj_reply】的数据库操作Service
 * @see IService
 */
public interface ReplyService extends IService<ReplyDo> {

    /**
     * 初始化/更新 关键词 单对单 回复 映射集合 缓存
     */
    void initOrUpdateRelayMap2Cache();
}
