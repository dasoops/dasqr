package com.dasoops.dasq.core.cq.service;

import com.dasoops.dasq.core.cq.entity.po.MethodInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Administrator
 * @description 针对表【TB_CQ_METHOD_INFO】的数据库操作Service
 * @createDate 2022-10-09 16:46:22
 */
public interface MethodInfoService extends IService<MethodInfo> {

    /**
     * 初始化/更新 MethodInfo Id-EntityJson 数据至redis
     */
    void initOrUpdate();

    /**
     * 通过passList关键词获取MethodInfo
     *
     * @param keyword 关键字
     * @return {@link MethodInfo}
     */
    MethodInfo getMethodInfoIdByKeyWord(String keyword);

    /**
     * 添加方法
     * <p>
     * .addMethod(GitUrl,do,{https://gitee.com/dasoopsnicole/dasServer},获取项目地址)
     *
     * @param keyword       passList关键字
     * @param typeKeyword   类型关键字
     * @param parametersStr 参数
     * @param description   描述
     */
    void addMethod(String keyword, String typeKeyword, String description, String parametersStr);

    /**
     * 得到帮助文档
     *
     * @return {@link String}
     */
    String getHelpDoc();
}
