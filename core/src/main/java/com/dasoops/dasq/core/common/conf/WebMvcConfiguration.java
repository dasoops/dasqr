package com.dasoops.dasq.core.common.conf;

import com.dasoops.dasq.core.common.interceptor.EventInfoInterceptor;
import com.dasoops.dasq.core.common.interceptor.LogInterceptor;
import com.dasoops.dasq.core.common.interceptor.PassListInterceptor;
import com.dasoops.dasq.core.common.interceptor.TokenVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title: WebMvcConfiguration
 * @ClassPath com.dasoops.dasq.core.conf.WebMvcConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/09
 * @Version 1.0.0
 * @Description: web mvc配置
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Resource
    private EventInfoInterceptor eventInfoInterceptor;
    @Resource
    private TokenVerifyInterceptor tokenVerifyInterceptor;
    @Resource
    private LogInterceptor logInterceptor;
    @Resource
    private PassListInterceptor passListInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器顺序 tokenVerify(token验证) heartBeat(心跳检测-暂未开启) passList(白名单) eventInfo(事件信息) log(日志打印)
        registry.addInterceptor(tokenVerifyInterceptor).addPathPatterns("/setting");
        registry.addInterceptor(passListInterceptor).addPathPatterns("/*").excludePathPatterns("/setting");
        registry.addInterceptor(eventInfoInterceptor).addPathPatterns("/*").excludePathPatterns("/setting");
        registry.addInterceptor(logInterceptor).addPathPatterns("/*");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
