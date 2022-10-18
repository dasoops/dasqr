//package com.dasoops.dasq.core.dq;
//
//import cn.hutool.core.util.StrUtil;
//import com.alibaba.fastjson2.JSON;
//import com.dasoops.dasq.core.common.service.DictionaryService;
//import com.dasoops.dasq.core.dq.entity.po.Mutation;
//import com.dasoops.dasq.core.dq.service.MutationService;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@SpringBootTest
//public class TestT {
//
//    @Resource
//    private MutationService mutationService;
//    @Resource
//    private DictionaryService dictionaryService;
//
//    @Test
//    public void test2() {
//        Map<String, String> factor = dictionaryService.getDictionaryMapByDictCode("factor");
//        Map<String, String> map = factor.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, res -> StrUtil.split(res.getValue(), "\\,").get(1)));
//
//        List<Mutation> list = mutationService.list();
//        List<Mutation> collect = list.stream().peek(res -> {
//            List<String> split = StrUtil.split(res.getFactor(), ",");
//            int score = 0;
//            for (String s : split) {
//                String s1 = map.get(s);
//
//                System.out.println(s);
//                System.out.println(s1);
//                score += s1 == null || s1.equals("-") ? 0 : Integer.parseInt(s1);
//            }
//
//            int level = 0;
//            if (score < 6) {
//                level = 1;
//            } else if (score < 8) {
//                level = 2;
//            } else if (score < 10) {
//                level = 3;
//            } else if (score < 12) {
//                level = 4;
//            } else if (score < 16) {
//                level = 5;
//            } else if (score < 20) {
//                level = 6;
//
//            }
//            res.setLevel(level);
//            res.setScore(score);
//
//        }).collect(Collectors.toList());
//        mutationService.updateBatchById(collect);
//
//
//    }
//}
