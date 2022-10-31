package com.dasoops.cq.mapper;

import com.dasoops.cq.entity.po.PluginPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Optional;

/**
 * @Title: PluginMapper
 * @ClassPath com.dasoops.cq.mapper.PluginMapper
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_PLUGIN(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Mapper
 * @see BaseMapper
 */
public interface PluginMapper extends BaseMapper<PluginPo> {

    /**
     * 选择所有类路径
     * 获取所有插件全类名路径
     *
     * @return {@link Optional}<{@link List}<{@link String}>>
     */
    Optional<List<String>> selectAllClassPath();

}




