package com.dasoops.dasserver.plugin.webmanager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dasoops.common.entity.vo.result.PageResult;
import com.dasoops.common.entity.vo.result.Result;
import com.dasoops.common.entity.vo.result.SimpleResult;
import com.dasoops.common.util.ExcelUtil;
import com.dasoops.dasserver.plugin.pluginwrapper.entity.param.AddPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.SortPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.dto.ExportPluginDto;
import com.dasoops.dasserver.plugin.webmanager.entity.param.DeletePluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.EditPluginParam;
import com.dasoops.dasserver.plugin.webmanager.entity.param.GetPluginPageParam;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginSortVo;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetPluginVo;
import com.dasoops.dasserver.plugin.webmanager.service.PluginWebService;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Title: PluginController
 * @ClassPath com.dasoops.dasserver.plugin.webmanager.controller.PluginController
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 插件控制器
 */

@RestController
@RequestMapping("plugin")
@Api(tags = "WM - 插件")
@ApiSupport(author = "DasoopsNicole@gmail.com")
@RequiredArgsConstructor
public class PluginController {

    private final PluginWebService pluginWebService;

    @GetMapping("getPluginPage")
    @ApiOperation(value = "获取分页插件信息", notes = "获取分页插件信息")
    public PageResult<GetPluginVo> getPluginPage(GetPluginPageParam param) {
        IPage<GetPluginVo> PluginDoPage = pluginWebService.getPluginPageData(param);
        return PageResult.success(PluginDoPage);
    }

    @PostMapping("editPlugin")
    @ApiOperation(value = "编辑插件", notes = "编辑插件")
    public SimpleResult editPlugin(@RequestBody EditPluginParam param) {
        pluginWebService.editPlugin(param);
        return SimpleResult.success();
    }

    @GetMapping("getNextId")
    @ApiOperation(value = "获取下一个自增主键id", notes = "获取下一个自增主键id")
    public Result<GetNextIdVo> getNextId() {
        GetNextIdVo getNextIdVo = pluginWebService.getNextId();
        return Result.success(getNextIdVo);
    }

    @PostMapping("addPlugin")
    @ApiOperation(value = "新增插件", notes = "新增插件")
    public SimpleResult addPlugin(@RequestBody AddPluginParam param) {
        pluginWebService.addPlugin(param);
        return SimpleResult.success();
    }

    @PostMapping("deletePlugin")
    @ApiOperation(value = "删除插件", notes = "删除插件")
    public SimpleResult deletePlugin(@RequestBody DeletePluginParam param) {
        pluginWebService.deletePlugin(param);
        return SimpleResult.success();
    }

    @GetMapping("exportAllPlugin")
    @ApiOperation(value = "导出所有插件", notes = "导出所有插件")
    public void exportAllPlugin(HttpServletResponse response) {
        List<ExportPluginDto> exportPluginDtoList = pluginWebService.exportAllPlugin();
        ExcelUtil.simpleExport(response, exportPluginDtoList, "pluginData");
    }

    @PostMapping("sortPlugin")
    @ApiOperation(value = "对插件排序", notes = "对插件排序")
    public SimpleResult sortPlugin(SortPluginParam param) {
        pluginWebService.sortPlugin(param);
        return SimpleResult.success();
    }

    @PostMapping("getPluginSort")
    @ApiOperation(value = "获取插件排序", notes = "获取插件排序")
    public Result<GetPluginSortVo> getPluginSort() {
        return Result.success(pluginWebService.getSortPlugin());
    }

}
