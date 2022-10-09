package com.dasoops.dasq.core.cq.service;

import com.dasoops.dasq.core.cq.entity.pojo.PassObject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_PASS_LIST(过滤白名单)】的数据库操作Service
 * @createDate 2022-10-07 16:40:31
 */
public interface PassListService extends IService<PassObject> {

    /**
     * 初始化/更新 PassListJsonSet 数据至redis
     */
    void initOrUpdatePassListJsonSet2Redis();
}
