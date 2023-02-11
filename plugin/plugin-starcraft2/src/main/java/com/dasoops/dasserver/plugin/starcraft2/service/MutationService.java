package com.dasoops.dasserver.plugin.starcraft2.service;

import com.dasoops.dasserver.plugin.starcraft2.entity.dbo.MutationDo;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【tb_plugin_star_craft_2_mutation(sc2 突变)】的数据库操作Service
 * @createDate 2023-01-20 19:24:24
 */
public interface MutationService {

    /**
     * 通过关键字获取集合
     *
     * @param keyword 关键字
     * @return {@link List}<{@link MutationDo}>
     */
    List<MutationDo> getListByKeyword(String keyword);

    /**
     * 自增记录数
     */
    void incrementRecord();
}
