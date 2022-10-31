package com.dasoops.cq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dasoops.cq.entity.po.ConfigPo;
import com.dasoops.cq.service.ConfigService;
import com.dasoops.cq.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

/**
 * @Title: ConfigServiceImpl
 * @ClassPath com.dasoops.cq.service.impl.ConfigServiceImpl
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_CONFIG(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service实现
 * @see ServiceImpl
 * @see ConfigService
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, ConfigPo>
    implements ConfigService{

}




