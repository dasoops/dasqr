package com.dasoops.dasserver.core;

import com.dasoops.common.config.BaseCorsFilter;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;

/**
 * @Title: CORSFilter
 * @ClassPath cn.qiaoml.config.CORSFilter
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/28
 * @Version 1.0.0
 * @Description: corsfilter 跨域 解决局域网前端问题
 * @see Filter
 */
@Component
public class CorsFilter extends BaseCorsFilter {

}