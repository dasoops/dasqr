package com.dasoops.dasserver.plugin.starcraft2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.service.ConfigService;
import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.MutationDo;
import com.dasoops.dasserver.plugin.starcraft2.entity.enums.StarCraft2ConfigHashKeyEnum;
import com.dasoops.dasserver.plugin.starcraft2.mapper.MutationMapper;
import com.dasoops.dasserver.plugin.starcraft2.service.MutationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【tb_plugin_star_craft_2_mutation(sc2 突变)】的数据库操作Service实现
 * @createDate 2023-01-20 19:24:24
 */
@Service
@RequiredArgsConstructor
public class MutationServiceImpl extends ServiceImpl<MutationMapper, MutationDo>
        implements MutationService {

    private final ConfigCache configCache;
    private final ConfigService configService;

    @Override
    public List<MutationDo> getListByKeyword(String keyword) {
        return super.lambdaQuery().like(MutationDo::getName, keyword).list();
    }

    @Override
    public void incrementRecord() {
        Integer record = configCache.getIntegerConfig(StarCraft2ConfigHashKeyEnum.MUTATION_RECORD);
        record++;

        configService.setConfig(StarCraft2ConfigHashKeyEnum.MUTATION_RECORD, String.valueOf(record));
    }
}




