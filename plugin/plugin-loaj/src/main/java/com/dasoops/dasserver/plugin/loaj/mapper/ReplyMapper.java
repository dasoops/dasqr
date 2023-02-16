package com.dasoops.dasserver.plugin.loaj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo;

/**
 * @title ReplyMapper
 * @classPath com.dasoops.dasserver.plugin.loaj.mapper.ReplyMapper
 * @author DasoopsNicole@Gmail.com
 * @date 2022/11/11
 * @version 1.0.0
 * @description 针对表【tb_plugin_loaj_reply】的数据库操作Mapper
 * @see BaseMapper
 */
public interface ReplyMapper extends BaseMapper<ReplyDo> {

    /**
     * 查询自增id
     *
     * @return {@link Long}
     */
    Long selectMaxId();
}




