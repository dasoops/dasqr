package com.dasoops.dasserver.plugin.starcraft2.plugin;

import cn.hutool.core.util.StrUtil;
import com.dasoops.common.entity.param.SimpleParam;
import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.cache.ConfigCache;
import com.dasoops.dasserver.cq.entity.annocation.MessageMapping;
import com.dasoops.dasserver.cq.entity.dto.cq.event.message.MessageParam;
import com.dasoops.dasserver.cq.entity.enums.MessageMappingTypeEnum;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.FactorDo;
import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.MutationDo;
import com.dasoops.dasserver.plugin.starcraft2.entity.enums.StarCraft2ConfigHashKeyEnum;
import com.dasoops.dasserver.plugin.starcraft2.entity.param.GetFactorParam;
import com.dasoops.dasserver.plugin.starcraft2.entity.param.GetMutationParam;
import com.dasoops.dasserver.plugin.starcraft2.service.FactorService;
import com.dasoops.dasserver.plugin.starcraft2.service.MutationService;
import com.dasoops.dasserver.plugin.starcraft2.service.impl.MutationSimpleSql;
import com.dasoops.minio.MinioTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @title StarCraftPlugin
 * @classPath com.dasoops.dasserver.plugin.starcraft2.plugin.StarCraftPlugin
 * @author DasoopsNicole@Gmail.com
 * @date 2023/01/20
 * @version 1.0.0
 * @description 星际插件
 * @see CqPlugin
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class StarCraftPlugin extends CqPlugin {


    private final ConfigCache configCache;
    private final MutationSimpleSql mutationSimpleSql;
    private final MutationService mutationService;
    private final FactorService factorService;
    private final MinioTemplate minioTemplate;

    /**
     * 查询周突变
     */
    final String thisWeekKeyword = "本周突变";
    final String nextWeekKeyword = "下周突变";

    @MessageMapping(equal = {thisWeekKeyword, nextWeekKeyword}, type = MessageMappingTypeEnum.ALL)
    public String getWeekMutation(MessageParam<SimpleParam> messageParam) {
        //记录数
        Integer recordRowId = configCache.getIntegerConfig(StarCraft2ConfigHashKeyEnum.MUTATION_RECORD);

        String matchKeyword = messageParam.getMatchKeyword();
        //死期
        final int bizzardDieWeek = 168;
        Integer bizzardLament = recordRowId - bizzardDieWeek;
        if (matchKeyword.equals(nextWeekKeyword)) {
            recordRowId++;
        }

        MutationDo mutationDo = mutationSimpleSql.getById(recordRowId);
        return StrUtil.format("""
                        星际死彻底的第{}周,阿门
                        {}: {}({})
                        因子:{}
                        分数:{}(残酷+{})
                        """,
                bizzardLament,
                matchKeyword, mutationDo.getName(), mutationDo.getMap(),
                mutationDo.getFactor(), mutationDo.getScore(), mutationDo.getLevel());
    }

    @MessageMapping(prefix = {"查询突变"}, type = MessageMappingTypeEnum.ALL)
    public String getMutation(MessageParam<GetMutationParam> messageParam) {
        Assert.getInstance().allMustNotNull(messageParam, messageParam.getParam(), messageParam.getParam().getKeyword());
        String keyword = messageParam.getParam().getKeyword();
        List<MutationDo> mutationList = mutationService.getListByKeyword(keyword);
        StringBuilder sb = new StringBuilder();
        sb.append(StrUtil.format("查询到{}个结果", mutationList.size()));
        for (int i = 0; i < mutationList.size(); i++) {
            MutationDo mutationDo = mutationList.get(i);
            sb.append("\n").append(i + 1).append(".");
            String str = StrUtil.format("""
                            {}({})
                            因子:{}
                            分数:{}(残酷+{})
                            """,
                    mutationDo.getName(), mutationDo.getMap(),
                    mutationDo.getFactor(),
                    mutationDo.getScore(), mutationDo.getLevel());
            sb.append(str);
        }
        return sb.toString();
    }


    /**
     * 获取因子
     *
     * @return boolean
     */
    @MessageMapping(prefix = {"因子查询", "getFactor"}, type = MessageMappingTypeEnum.ALL)
    public String getFactor(MessageParam<GetFactorParam> messageParam) {
        Assert.getInstance().allMustNotNull(messageParam, messageParam.getParam(), messageParam.getParam().getName());

        FactorDo factorDo = factorService.getFactorByName(messageParam.getParam().getName());
        //无参
        if (factorDo == null) {
            return "没有这个因子捏!";
        }

        return StrUtil.format("{}\r\n{}({}分)\r\n{}",
                CqCodeUtil.image(minioTemplate.buildImagePath(factorDo.getImageFileName())),
                factorDo.getName(), factorDo.getScore(), factorDo.getDescription());
    }

}
