package com.dasoops.dasserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.entity.param.EditConfigParam;
import com.dasoops.dasserver.entity.param.GetConfigEasyPageParam;

/**
 * @Title: ConfigService
 * @ClassPath com.dasoops.dasserver.cq.service.ConfigService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【TB_CORE_CONFIG(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service
 * @see IService
 */
public interface ConfigWebService extends IService<ConfigDo> {

    /**
     * 获取配置页面数据
     *
     * @param param 参数
     * @return {@link IPage}<{@link ConfigDo}>
     */
    IPage<ConfigDo> getConfigPageData(GetConfigEasyPageParam param);

    /**
     * 编辑配置项
     *
     * @param param 参数
     */
    void editConfig(EditConfigParam param);
}
