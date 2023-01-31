package com.dasoops.dasserver.plugin.loaj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dasoops.dasserver.plugin.loaj.entity.dbo.ReplyDo;

/**
 * @Title: ReplyMapper
 * @ClassPath com.dasoops.dasserver.plugin.loaj.mapper.ReplyMapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/11
 * @Version 1.0.0
 * @Description: 针对表【tb_plugin_loaj_reply】的数据库操作Mapper
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




