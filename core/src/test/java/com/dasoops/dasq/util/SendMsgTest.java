package com.dasoops.dasq.util;

import com.dasoops.dasq.core.DasServerApplication;
import com.dasoops.dasq.core.cq.service.CqService;
import com.dasoops.dasq.core.cq.service.PassListService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest(classes = DasServerApplication.class)
public class SendMsgTest {

    @Resource
    private CqService cqService;
    @Resource
    PassListService passListService;

    @Test
    public void test() {
//        cqService.sendMsg(false,776465218L,"123");
//        Map<String, String> passKeywordGetMethodInfoMap = passListService.getPassListKeywordGetMethodInfoList();
//        System.out.println(passKeywordGetMethodInfoMap);
    }


}
