package com.dasoops.dasserver.plugin.loaj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.common.entity.enums.base.DbBooleanEnum;
import com.dasoops.dasserver.plugin.loaj.cache.ReplyCache;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ReplyRedisValueDto;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyIgnoreCaseEnum;
import com.dasoops.dasserver.plugin.loaj.entity.enums.ReplyIgnoreDbcEnum;
import com.dasoops.dasserver.plugin.loaj.entity.po.ReplyDo;
import com.dasoops.dasserver.plugin.loaj.mapper.ReplyMapper;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
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
}




