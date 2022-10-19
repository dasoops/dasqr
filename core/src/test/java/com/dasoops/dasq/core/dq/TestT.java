package com.dasoops.dasq.core.dq;

import cn.hutool.db.nosql.mongo.MongoFactory;
import com.dasoops.dasq.core.common.service.DictionaryService;
import com.dasoops.dasq.core.dq.entity.pojo.Factor;
import com.dasoops.dasq.core.dq.service.FactorService;
import com.dasoops.dasq.core.dq.service.MutationService;
import com.dasoops.dasq.core.image.service.ImageInfoService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestT {

    @Resource
    private MutationService mutationService;
    @Resource
    private DictionaryService dictionaryService;
    @Resource
    private FactorService factorService;
    @Resource
    private ImageInfoService imageInfoService;

    @org.junit.jupiter.api.Test
    public void test() {


    }

}
