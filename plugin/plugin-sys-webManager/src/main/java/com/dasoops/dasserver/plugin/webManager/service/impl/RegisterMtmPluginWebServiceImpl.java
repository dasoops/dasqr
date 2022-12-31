package com.dasoops.dasserver.plugin.webManager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.dasserver.cq.entity.dbo.RegisterMtmPluginDo;
import com.dasoops.dasserver.cq.service.RegisterMtmPluginService;
import com.dasoops.dasserver.plugin.webManager.service.RegisterMtmPluginWebService;
import com.dasoops.dasserver.plugin.webManager.mapper.RegisterMtmPluginWebMapper;
import org.springframework.stereotype.Service;

/**
 * @Title: RegisterMtmPluginServiceImpl
 * @ClassPath com.dasoops.dasserver.cq.service.impl.RegisterMtmPluginServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/01
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_REGISTER_MTM_PLUGIN】的数据库操作Service实现
 * @see ServiceImpl
 * @see RegisterMtmPluginService
 */
@Service
public class RegisterMtmPluginWebServiceImpl extends ServiceImpl<RegisterMtmPluginWebMapper, RegisterMtmPluginDo>
    implements RegisterMtmPluginWebService {

}




