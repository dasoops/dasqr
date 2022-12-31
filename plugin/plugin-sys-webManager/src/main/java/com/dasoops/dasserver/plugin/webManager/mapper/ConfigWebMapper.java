package com.dasoops.dasserver.plugin.webManager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;

/**
 * @Title: ConfigMapper
 * @ClassPath com.dasoops.dasserver.cq.mapper.ConfigMapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_CONFIG(配置表,储存配置信息,如:version,mutation等)】的数据库操作Mapper
 * @see BaseMapper
 */
public interface ConfigWebMapper extends BaseMapper<ConfigDo> {

    /**
     * 查询自增id
     *
     * @return {@link Long}
     */
    Long queryMaxId();


}




