package com.dasoops.dasq.core.cq.service;

import com.dasoops.dasq.core.cq.entity.po.MethodType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Administrator
 * @description 针对表【TB_CQ_METHOD_TYPE】的数据库操作Service
 * @createDate 2022-10-09 16:46:22
 */
public interface MethodTypeService extends IService<MethodType> {

    /**
     * 初始化/更新 MethodType Id-EntityJson 数据至redis
     */
    void initOrUpdate();

    /**
     * 添加方法类型
     *
     * @param keyword     关键字
     * @param hasScan     已经扫描
     * @param description 描述
     */
    void addMethodType(String keyword, String hasScan, String description);
}
