package com.dasoops.dasserver.core;

import com.dasoops.common.config.BaseCorsFilter;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;

/**
 * @title CORSFilter
 * @classPath cn.qiaoml.config.CORSFilter
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/28
 * @version 1.0.0
 * @description corsfilter 跨域 解决局域网前端问题
 * @see Filter
 */
@Component
public class CorsFilter extends BaseCorsFilter {

}