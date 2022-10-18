package com.dasoops.dasq.core.dq.mapper;

import com.dasoops.dasq.core.dq.entity.po.Mutation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【TB_OTHER_SC2_MUTATION(sc2 突变)】的数据库操作Mapper
 * @createDate 2022-10-18 11:10:32
 * @Entity com.dasoops.dasq.core.dq.entity.pojo.Mutation
 */
public interface MutationMapper extends BaseMapper<Mutation> {

    /**
     * 通过关键字获取突变集合
     *
     * @param keyword 关键字
     * @return {@link List}<{@link Mutation}>
     */
    List<Mutation> selectListByKeyword(@Param("keyword") String keyword);

}




