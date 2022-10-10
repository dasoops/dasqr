package com.dasoops.dasq.core.cq.service;

import com.dasoops.dasq.core.cq.entity.bo.PassKeywordGetMethodInfoIdBo;
import com.dasoops.dasq.core.cq.entity.enums.CqKeywordEnum;
import com.dasoops.dasq.core.cq.entity.po.PassObject;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_PASS_LIST(过滤白名单)】的数据库操作Service
 * @createDate 2022-10-07 16:40:31
 */
public interface PassListService extends IService<PassObject> {

    /**
     * 初始化/更新 PassListTypeGetEntityJsonSetMap 数据至redis
     */
    void initOrUpdatePassListTypeGetEntityJsonSetMap2Redis();

    /**
     * 初始化/更新 白名单关键词-方法info id映射集合 数据至redis
     */
    void initOrUpdatePassListKeywordGetMethodInfoMap2Redis();

    /**
     * 通过类型获取白名单
     *
     * @param type 类型
     * @return {@link Optional}<{@link List}<{@link PassObject}>>
     */
    Optional<List<PassObject>> getPassListByType(Integer type);

    /**
     * 获取白名单关键词-方法info id映射集合
     *
     * @return {@link List}<{@link PassKeywordGetMethodInfoIdBo}>
     */
    List<PassKeywordGetMethodInfoIdBo> getPassListKeywordGetMethodInfoList();
}
