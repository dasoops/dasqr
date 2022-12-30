package com.dasoops.dasserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dasoops.common.entity.vo.result.PageResult;
import com.dasoops.common.entity.vo.result.SimpleResult;
import com.dasoops.dasserver.cq.entity.dbo.ConfigDo;
import com.dasoops.dasserver.entity.param.EditConfigParam;
import com.dasoops.dasserver.entity.param.GetConfigEasyPageParam;
import com.dasoops.dasserver.entity.vo.GetConfigVo;
import com.dasoops.dasserver.service.ConfigWebService;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: ConfigController
 * @ClassPath com.dasoops.dasserver.sys.user.controller.ConfigController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/28
 * @Version 1.0.0
 * @Description: 配置 控制器
 */
@RestController
@RequestMapping("config")
public class ConfigController {

    private final ConfigWebService configWebService;

    public ConfigController(ConfigWebService configWebService) {
        this.configWebService = configWebService;
    }

    @GetMapping("getConfigPage")
    public PageResult<GetConfigVo> getConfigPage(GetConfigEasyPageParam param) {
        IPage<ConfigDo> configDoPage = configWebService.getConfigPageData(param);
        return PageResult.success(configDoPage, GetConfigVo.class);
    }

    @PostMapping("editConfig")
    public SimpleResult editConfig(@RequestBody EditConfigParam param){
        configWebService.editConfig(param);
        return SimpleResult.success();
    }



}
