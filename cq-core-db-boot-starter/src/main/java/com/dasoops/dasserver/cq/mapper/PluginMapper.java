package com.dasoops.dasserver.cq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dasoops.dasserver.cq.entity.po.PluginPo;

import java.util.List;

/**
 * @Title: PluginMapper
 * @ClassPath com.dasoops.dasserver.cq.mapper.PluginMapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_PLUGIN(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Mapper
 * @see BaseMapper
 */
public interface PluginMapper extends BaseMapper<PluginPo> {

    /**
     * 获取所有插件全类名路径
     *
     * @return {@link List}<{@link String}>
     */
    List<String> selectAllClassPathOrderByOrder();

    /**
     * 得到最大序号
     *
     * @return {@link Integer}
     */
    Integer getMaxOrder();
}




