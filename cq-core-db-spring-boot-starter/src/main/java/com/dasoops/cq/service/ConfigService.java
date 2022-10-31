package com.dasoops.cq.service;

import com.dasoops.cq.entity.po.ConfigPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Title: ConfigService
 * @ClassPath com.dasoops.cq.service.ConfigService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_CONFIG(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service
 * @see IService
 */
public interface ConfigService extends IService<ConfigPo> {

}
