package com.dasoops.dasq.core.cq.service;

import com.dasoops.dasq.core.cq.entity.pojo.MethodInfo;
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
    void initOrUpdateMethodInfoIdEntityJson2Redis();
}
