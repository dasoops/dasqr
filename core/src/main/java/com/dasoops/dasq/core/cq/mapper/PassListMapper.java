package com.dasoops.dasq.core.cq.mapper;

import com.dasoops.dasq.core.cq.entity.bo.PassKeywordGetMethodInfoIdBo;
import com.dasoops.dasq.core.cq.entity.po.PassObject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_PASS_LIST(过滤白名单)】的数据库操作Mapper
 * @createDate 2022-10-07 16:40:31
 * @Entity com.dasoops.dasq.entify.PassList
 */
public interface PassListMapper extends BaseMapper<PassObject> {

    /**
     * 获取白名单关键词-方法info id映射集合
     *
     * @return {@link Map}<{@link String}, {@link Long}>
     */
    List<PassKeywordGetMethodInfoIdBo> selectPassKeywordGetMethodInfoMap();

}




