package com.dasoops.dasq.core.common.conf;

import com.dasoops.dasq.core.common.interceptor.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

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
    private AuthorMatchInterceptor authorMatchInterceptor;
    @Resource
    private RereadInterceptor rereadInterceptor;
    @Resource
    private CoolStyleInterceptor coolStyleInterceptor;
    @Resource
    private PostTypeMatchInterceptor postTypeMatchInterceptor;
    @Resource
    private SaveImagePartInterceptor saveImagePartInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器顺序 tokenVerify(token验证) heartBeat(心跳检测-暂未开启) passList(白名单) eventInfo(事件信息) log(日志打印)
        String setting = "/setting/*";
        String alas = "/alas/error";
        String git = "/git/push";
        registry.addInterceptor(tokenVerifyInterceptor).addPathPatterns(setting);
        registry.addInterceptor(postTypeMatchInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        registry.addInterceptor(authorMatchInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        registry.addInterceptor(rereadInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        registry.addInterceptor(saveImagePartInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        registry.addInterceptor(coolStyleInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        registry.addInterceptor(eventInfoInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        registry.addInterceptor(logInterceptor).addPathPatterns("/*").excludePathPatterns(alas, git);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
