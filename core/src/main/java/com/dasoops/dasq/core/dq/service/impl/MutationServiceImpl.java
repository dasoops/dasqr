package com.dasoops.dasq.core.dq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasq.core.dq.entity.po.Mutation;
import com.dasoops.dasq.core.dq.service.MutationService;
import com.dasoops.dasq.core.dq.mapper.MutationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @description 针对表【TB_OTHER_SC2_MUTATION(sc2 突变)】的数据库操作Service实现
 * @createDate 2022-10-18 11:10:32
 */
@Service
public class MutationServiceImpl extends ServiceImpl<MutationMapper, Mutation>
        implements MutationService {

    @Resource
    private MutationMapper mutationMapper;

    @Override
    public List<Mutation> getListByKeyword(String keyword) {
        return mutationMapper.selectListByKeyword(keyword);
    }


}




