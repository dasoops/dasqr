package com.dasoops.dasserver.plugin.loaj.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.base.DbBooleanEnum;
import com.dasoops.common.entity.enums.base.IDbColumnEnum;
import com.dasoops.common.exception.LogicException;
import com.dasoops.common.util.Assert;
import com.dasoops.common.util.Convert;
import com.dasoops.dasserver.plugin.loaj.cache.ReplyCache;
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ExportReplyDto;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ReplyRedisValueDto;
import com.dasoops.dasserver.plugin.loaj.entity.enums.LoajExceptionEnum;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyIgnoreCaseEnum;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyIgnoreDbcEnum;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyMatchTypeEnum;
import com.dasoops.dasserver.plugin.loaj.entity.param.AddReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.DeleteReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.EditReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.GetReplyPageParam;
import com.dasoops.dasserver.plugin.loaj.entity.vo.GetReplyVo;
import com.dasoops.dasserver.plugin.loaj.mapper.ReplyMapper;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
import com.dasoops.dasserver.plugin.webmanager.entity.enums.WebManagerExceptionEnum;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final ReplyMapper replyMapper;

    @Override
    public void initOrUpdateRelayMap2Cache() {
        log.info("初始化/更新 关键词 单对单 回复 映射集合 缓存");
        List<ReplyDo> list = super.lambdaQuery().eq(ReplyDo::getEnable, DbBooleanEnum.TRUE).list();
        if (list.size() <= 0) {
            return;
        }
        //获取 关键词回复 映射集合
        Set<ReplyRedisValueDto> replyRedisValueSet = list.stream()
                //启用的
                .filter(replyDo -> DbBooleanEnum.TRUE.getDbValue().equals(replyDo.getEnable()))
                //convert
                .map(replyDo -> {
                    ReplyRedisValueDto dto = new ReplyRedisValueDto();
                    dto.setKeyword(replyDo.getKeyword());
                    dto.setReply(replyDo.getReply());
                    dto.setMatchType(replyDo.getMatchType());
                    dto.setIgnoreCase(ReplyIgnoreCaseEnum.TRUE.getDbValue().equals(replyDo.getIgnoreCase()));
                    dto.setIgnoreDbc(ReplyIgnoreDbcEnum.TRUE.getDbValue().equals(replyDo.getIgnoreDbc()));
                    return dto;
                }).collect(Collectors.toSet());
        replyCache.setReplySet(replyRedisValueSet);
    }

    @Override
    @SuppressWarnings("all")
    public IPage<GetReplyVo> getReplyPageData(GetReplyPageParam param) {
        LambdaQueryWrapper<ReplyDo> wrapper = param.buildQueryWrapper().lambda()
                .like(ObjUtil.isNotEmpty(param.getMatchKeyword()), ReplyDo::getKeyword, param.getMatchKeyword())
                .in(ObjUtil.isNotEmpty(param.getMatchTypeList()), ReplyDo::getMatchType, param.getMatchTypeList());

        List<Integer> matchTypeList = param.getMatchTypeList();
        if (ObjUtil.isNotEmpty(matchTypeList)) {
            List<Integer> allProbableValue = IDbColumnEnum.getAllProbableValue(ReplyMatchTypeEnum.class);
            if (!allProbableValue.containsAll(matchTypeList)) {
                throw new LogicException(LoajExceptionEnum.UNDEFINEND_MATCH_TYPE);
            }
        }

        return super.page(param.buildSelectPage(), wrapper).convert(replyDo -> Convert.to(replyDo, GetReplyVo.class));
    }

    @Override
    public GetNextIdVo getNextId() {
        Long maxRowId = replyMapper.selectMaxId();
        GetNextIdVo getNextIdVo = new GetNextIdVo();
        getNextIdVo.setRowId(maxRowId);
        return getNextIdVo;
    }

    @Override
    public void editReply(EditReplyParam param) {
        Assert.getInstance().allMustNotNull(param, param.getRowId(), param.getKeyword(), param.getReply(), param.getEnable(), param.getIgnoreCase(), param.getIgnoreDbc(), param.getMatchType());
        checkRowId(param.getRowId());
        ReplyDo replyDo = param.buildDo();
        super.updateById(replyDo);
    }

    @Override
    public void addReply(AddReplyParam param) {
        Assert.getInstance().allMustNotNull(param, param.getReply(), param.getEnable(), param.getIgnoreCase(), param.getIgnoreDbc(), param.getMatchType());
        ReplyDo replyDo = Convert.to(param, ReplyDo.class);
        super.save(replyDo);
    }

    @Override
    public void deleteReply(DeleteReplyParam param) {
        Assert.getInstance().allMustNotNull(param, param.getRowId());
        super.removeById(param.getRowId());
    }

    @Override
    public List<ExportReplyDto> exportAllReply() {
        return Convert.to(super.list(), ExportReplyDto.class);
    }

    private ReplyDo checkRowId(Long rowId) {
        ReplyDo byId = super.getById(rowId);
        if (byId == null) {
            throw new LogicException(WebManagerExceptionEnum.UNDEFINED_ID);
        }
        return byId;
    }
}




