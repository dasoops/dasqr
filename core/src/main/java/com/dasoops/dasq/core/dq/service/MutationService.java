package com.dasoops.dasq.core.dq.service;

import com.dasoops.dasq.core.dq.entity.po.Mutation;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【TB_OTHER_SC2_MUTATION(sc2 突变)】的数据库操作Service
 * @createDate 2022-10-18 11:10:32
 */
public interface MutationService extends IService<Mutation> {

    /**
     * 通过关键字获取列表
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Mutation}>
     */
    List<Mutation> getListByKeyword(String keyword);
}
