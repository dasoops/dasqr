package com.dasoops.dasserver.plugin.webmanager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dasoops.common.entity.result.PageResult;
import com.dasoops.common.entity.result.Result;
import com.dasoops.common.entity.result.SimpleResult;
import com.dasoops.common.util.ExcelUtil;
import com.dasoops.dasserver.plugin.webmanager.entity.param.config.EditConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webmanager.service.ConfigWebService;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportConfigDto;
import com.dasoops.dasserver.plugin.webmanager.entity.param.config.AddConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.config.DeleteConfigParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.config.GetConfigPageParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.config.GetConfigVo;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @title: ConfigController
 * @classPath com.dasoops.dasserver.sys.user.controller.ConfigController
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/28
 * @version 1.0.0
 * @description 配置 控制器
 */
@RestController
@RequestMapping("config")
@Api(tags = "WM - 配置")
@ApiSupport(author = "DasoopsNicole@gmail.com")
@RequiredArgsConstructor
public class ConfigController {

    private final ConfigWebService configWebService;

    @GetMapping("getConfigPage")
    @ApiOperation(value = "获取分页配置信息", notes = "获取分页配置信息")
    public PageResult<GetConfigVo> getConfigPage(GetConfigPageParam param) {
        IPage<GetConfigVo> configDoPage = configWebService.getConfigPageData(param);
        return PageResult.success(configDoPage);
    }

    @PostMapping("editConfig")
    @ApiOperation(value = "编辑配置", notes = "编辑配置")
    public SimpleResult editConfig(@RequestBody EditConfigParam param) {
        configWebService.editConfig(param);
        return SimpleResult.success();
    }

    @GetMapping("getNextId")
    @ApiOperation(value = "获取下一个自增主键id", notes = "获取下一个自增主键id")
    public Result<GetNextIdVo> getNextId() {
        GetNextIdVo getNextIdVo = configWebService.getNextId();
        return Result.success(getNextIdVo);
    }

    @PostMapping("addConfig")
    @ApiOperation(value = "新增配置", notes = "新增配置")
    public SimpleResult addConfig(@RequestBody AddConfigParam param) {
        configWebService.addConfig(param);
        return SimpleResult.success();
    }

    @PostMapping("deleteConfig")
    @ApiOperation(value = "删除配置", notes = "删除配置")
    public SimpleResult deleteConfig(@RequestBody DeleteConfigParam param) {
        configWebService.deleteConfig(param);
        return SimpleResult.success();
    }

    @GetMapping("exportAllConfig")
    @ApiOperation(value = "导出所有配置", notes = "导出所有配置")
    public void exportAllConfig(HttpServletResponse response) {
        List<ExportConfigDto> exportConfigDtoList = configWebService.exportAllConfig();
        ExcelUtil.Companion.simpleExport(response, exportConfigDtoList, "ConfigData");
    }

}
