package com.dasoops.dasserver.plugin.loaj.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.Insert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.base.DbBooleanEnum;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.plugin.loaj.cache.ReplyCache;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ExportReplyDto;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ReplyRedisValueDto;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyIgnoreCaseEnum;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyIgnoreDbcEnum;
import com.dasoops.dasserver.plugin.loaj.entity.param.AddReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.DeleteReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.EditReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.GetReplyPageParam;
import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import com.dasoops.dasserver.plugin.loaj.entity.vo.GetReplyVo;
import com.dasoops.dasserver.plugin.loaj.mapper.ReplyMapper;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Title: ReplyServiceImpl
 * @ClassPath com.dasoops.dasserver.plugin.loaj.service.impl.ReplyServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/11
 * @Version 1.0.0
 * @Description: 针对表【tb_plugin_loaj_reply】的数据库操作Service实现
 * @see ServiceImpl
 * @see ReplyService
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, ReplyDo>
        implements ReplyService {

    private final ReplyCache replyCache;
//
//    @Autowired
//    private  ReplyMapper ;

    @Override
    public void initOrUpdateRelayMap2Cache() {
        log.info("初始化/更新 关键词 单对单 回复 映射集合 缓存");
        List<ReplyDo> list = super.lambdaQuery().eq(ReplyDo::getEnable, DbBooleanEnum.TRUE).list();
        if (list.size() <= 0) {
            return;
        }
        //获取 关键词回复 映射集合
        Set<ReplyRedisValueDto> replyRedisValueSet = list.stream().map(replyDo -> {
            ReplyRedisValueDto dto = new ReplyRedisValueDto();
            dto.setKeyword(replyDo.getKeyword());
            dto.setReply(replyDo.getReply());
            dto.setMatchType(replyDo.getMatchType());
            dto.setIgnoreCase(replyDo.getIgnoreCase().equals(ReplyIgnoreCaseEnum.TRUE.getDbValue()));
            dto.setIgnoreDbc(replyDo.getIgnoreDbc().equals(ReplyIgnoreDbcEnum.TRUE.getDbValue()));
            return dto;
        }).collect(Collectors.toSet());
        replyCache.setReplySet(replyRedisValueSet);
    }

    @Override
    public IPage<GetReplyVo> getReplyPageData(GetReplyPageParam param) {
        return null;
    }

    @Override
    public GetNextIdVo getNextId() {
        return null;
    }

    @Override
    public void editReply(EditReplyParam param) {
    super.lambdaUpdate().eq(ReplyDo::getRowId,param.getRowId()).set(ReplyDo::getReply,param.getReply())
            .set(ReplyDo::getEnable,param.getEnable())
            .set(ReplyDo::getMatchType,param.getMatchType())
            .set(ReplyDo::getIgnoreCase,param.getIgnoreCase())
            .set(ReplyDo::getIgnoreDbc,param.getIgnoreDbc())
            .update();

    }

    @Override
    public void addReply(AddReplyParam param) {
        ReplyDo replyDo = Convert.to(param, ReplyDo.class);
//        replyDo.setEnable();
        super.save(replyDo);
        //replyMapper.insert(replyDo);
    }

    @Override
    public void deleteReply(DeleteReplyParam param) {
//        ReplyDo replyDo = Convert.to(param, ReplyDo.class);
        //replyDo.setIsDelete(1);
//        QueryWrapper<ReplyDo> replyDoWrapper = new QueryWrapper<>().lambda(ReplyDo::setRowId,param.getRowId());
//        replyDoWrapper.set
//        replyMapper.selectOne()
        super.lambdaUpdate().eq(ReplyDo::getRowId,param.getRowId())
                .set(ReplyDo::getIsDelete,DbBooleanEnum.FALSE)
                .update();
    }

    @Override
    public List<ExportReplyDto> exportAllReply() {
        List<ReplyDo> replyDos = super.lambdaQuery().eq(ReplyDo::getIsDelete, 0).list();
        return Convert.to(replyDos, ExportReplyDto.class);
    }
}




