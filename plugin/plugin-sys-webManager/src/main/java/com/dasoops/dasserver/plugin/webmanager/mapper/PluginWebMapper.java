package com.dasoops.dasserver.plugin.webmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;

/**
 * @title: PluginMapper
 * @classPath com.dasoops.dasserver.cq.mapper.PluginMapper
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 针对表【tb_core_plugin(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Mapper
 * @see BaseMapper
 */
public interface PluginWebMapper extends BaseMapper<PluginDo> {

    /**
     * 查询自增id
     *
     * @return {@link Long}
     */
    Long selectMaxId();

    /**
     * 查询最大排序
     *
     * @return {@link Integer}
     */
    Integer selectMaxOrder();
}




