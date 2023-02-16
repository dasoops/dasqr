package com.dasoops.dasserver.plugin.webmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;

/**
 * @title ConfigMapper
 * @classPath com.dasoops.dasserver.cq.mapper.ConfigMapper
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/31
 * @version 1.0.0
 * @description 针对表【tb_core_config(配置表,储存配置信息,如:version,mutation等)】的数据库操作Mapper
 * @see BaseMapper
 */
public interface ConfigWebMapper extends BaseMapper<ConfigDo> {

    /**
     * 查询自增id
     *
     * @return {@link Long}
     */
    Long selectMaxId();


}




