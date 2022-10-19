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
        String setting = "/setting/*";
        String alas = "/alas/error";
        String git = "/git/push";
        //TokenVerify(token验证)
        registry.addInterceptor(tokenVerifyInterceptor).addPathPatterns(setting);
        //HeartBeat(心跳检测-暂未开启)
        //PostType(消息类型)
        registry.addInterceptor(postTypeMatchInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        //Log(日志)
        registry.addInterceptor(logInterceptor).addPathPatterns("/*").excludePathPatterns(alas, git);
        //AuthorMatch(用户白名单匹配)
        registry.addInterceptor(authorMatchInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        //Reread(复读)
        registry.addInterceptor(rereadInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        //SaveImagePart(分段存图)
        registry.addInterceptor(saveImagePartInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        //CoolStyle(风格)
        registry.addInterceptor(coolStyleInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        //EventInfo(用户信息)
        registry.addInterceptor(eventInfoInterceptor).addPathPatterns("/*").excludePathPatterns(setting, alas, git);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
