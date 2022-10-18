package com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other;//import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;

import cn.hutool.core.util.StrUtil;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.dq.entity.po.Mutation;
import com.dasoops.dasq.core.dq.mapper.MutationMapper;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseCqMethodStrategy;
import com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.base.BaseMethodStrategy;
import com.dasoops.dasq.core.dq.service.MutationService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: MutationStrategy
 * @ClassPath com.dasoops.dasq.core.dq.methodstrategy.stratepyentity.other.MutationStrategy
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/18
 * @Version 1.0.0
 * @Description: 突变策略
 * @see BaseMethodStrategy
 * @see BaseCqMethodStrategy
 */
@Component
public class MutationStrategy extends BaseMethodStrategy implements BaseCqMethodStrategy {

    //addMethodType mutation,1,获取突变信息
    //addMethod 下周突变,mutation,查询下周突变信息,{}
    //addMethod 查询突变,mutation,查询突变信息,{$param0}

    @Resource
    private MutationService mutationService;
    @Resource
    private DictionaryService dictionaryService;


    @Override
    public Long getId() {
        return 1582213312663265282L;
    }

    @Override
    public void invoke(List<String> params) {
        //无参
        if (params == null || params.isEmpty()) {
            cqService.sendMsg("没有这个突变捏!");
            return;
        }

        String param = params.get(0);
        //下周突变

        final String lastStr = "last";
        final String thisStr = "this";
        boolean lastFlag = lastStr.equals(param);
        boolean thisFlag = thisStr.equals(param);

        //下周突变||本周突变
        if (lastFlag || thisFlag) {
            String mutation = dictionaryService.getDictValueByDictCode("mutation");
            //下周突变需要 + 1
            Mutation lastMutation = mutationService.getById(Long.parseLong(mutation) + (lastFlag ? 1L : 0L));
            cqService.sendMsg(StrUtil.format("下周突变: {}({})\n因子:{}\n分数:{}(残酷+{})",
                    lastMutation.getName(), lastMutation.getMap(), lastMutation.getFactor(), lastMutation.getScore(), lastMutation.getLevel()));
            return;
        }


        //查询突变
        List<Mutation> mutationList = mutationService.getListByKeyword(param);
        StringBuilder sb = new StringBuilder();
        sb.append(StrUtil.format("查询到{}个结果", mutationList.size()));
        for (int i = 0; i < mutationList.size(); i++) {
            Mutation mutation = mutationList.get(i);
            sb.append("\n").append(i + 1).append(".");
            String str = StrUtil.format("{}({})\n因子:{}\n分数:{}(残酷+{})", mutation.getName(), mutation.getMap(), mutation.getFactor(), mutation.getScore(), mutation.getLevel());
            sb.append(str);
        }
        cqService.sendMsg(sb.toString());
    }
}
