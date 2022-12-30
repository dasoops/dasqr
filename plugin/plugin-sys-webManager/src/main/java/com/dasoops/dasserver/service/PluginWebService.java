package com.dasoops.dasserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.CqPlugin;
import com.dasoops.dasserver.cq.entity.dbo.PluginDo;

import java.util.List;
import java.util.Optional;

/**
 * @Title: PluginService
 * @ClassPath com.dasoops.dasserver.cq.service.PluginService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_PLUGIN(插件表,储存插件注册信息,权限,描述,启用状态等)】的数据库操作Service
 * @see IService
 */
public interface PluginWebService extends IService<PluginDo> {

}
