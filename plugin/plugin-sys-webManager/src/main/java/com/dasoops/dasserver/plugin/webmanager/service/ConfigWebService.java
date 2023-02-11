package com.dasoops.dasserver.plugin.webmanager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportConfigDto;
import com.dasoops.dasserver.plugin.webmanager.entity.param.config.AddConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.config.DeleteConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.config.EditConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.config.GetConfigPageParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.config.GetConfigVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;

import java.util.List;

/**
 * @Title: ConfigService
 * @ClassPath com.dasoops.dasserver.cq.service.ConfigService
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/31
 * @Version 1.0.0
 * @Description: 针对表【tb_core_config(配置表,储存配置信息,如:version,mutation等)】的数据库操作Service
 * @see IService
 */
public interface ConfigWebService {

    /**
     * 获取配置页面数据
     *
     * @param param 参数
     * @return {@link IPage}<{@link ConfigDo}>
     */
    IPage<GetConfigVo> getConfigPageData(GetConfigPageParam param);

    /**
     * 编辑配置项
     *
     * @param param 参数
     */
    void editConfig(EditConfigParam param);

    /**
     * 获取下一个自增主键id
     *
     * @return {@link Long}
     */
    GetNextIdVo getNextId();

    /**
     * 添加配置
     *
     * @param param 参数
     */
    void addConfig(AddConfigParam param);

    /**
     * 删除配置
     *
     * @param param 参数
     */
    void deleteConfig(DeleteConfigParam param);

    /**
     * 导出所有配置
     *
     * @return {@link List}<{@link ExportConfigDto}>
     */
    List<ExportConfigDto> exportAllConfig();
}
