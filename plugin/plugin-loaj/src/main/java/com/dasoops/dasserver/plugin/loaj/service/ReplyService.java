package com.dasoops.dasserver.plugin.loaj.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ExportReplyDto;
import com.dasoops.dasserver.plugin.loaj.entity.param.AddReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.DeleteReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.EditReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.GetReplyPageParam;
import com.dasoops.dasserver.plugin.loaj.entity.vo.GetReplyVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;

import java.util.List;

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

    /**
     * 获取回复页面数据
     *
     * @param param param
     * @return {@link IPage}<{@link GetReplyVo}>
     */
    IPage<GetReplyVo> getReplyPageData(GetReplyPageParam param);

    /**
     * 获取下一个自增id
     *
     * @return {@link GetNextIdVo}
     */
    GetNextIdVo getNextId();

    /**
     * 编辑回复
     *
     * @param param param
     */
    void editReply(EditReplyParam param);

    /**
     * 添加回复
     *
     * @param param param
     */
    void addReply(AddReplyParam param);

    /**
     * 删除回复
     *
     * @param param param
     */
    void deleteReply(DeleteReplyParam param);

    /**
     * 导出所有回复
     *
     * @return {@link List}<{@link ExportReplyDto}>
     */
    List<ExportReplyDto> exportAllReply();
}
