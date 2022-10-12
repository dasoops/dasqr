package com.dasoops.dasq.core.common.event;

import com.dasoops.dasq.core.common.util.BannerUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Title: BannerRunner
 * @ClassPath com.dasoops.dasq.core.common.event.BunnerRunner
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/12
 * @Version 1.0.0
 * @Description: bannerRunner
 * @see ApplicationRunner
 */
@Component
@Order(value = 2)
public class BannerRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BannerUtil.printBanner();
    }
}
