package com.dasoops.dasserver.plugin.loaj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dasoops.common.entity.result.PageResult;
import com.dasoops.common.entity.result.Result;
import com.dasoops.common.entity.result.SimpleResult;
import com.dasoops.common.util.ExcelUtil;
import com.dasoops.dasserver.plugin.loaj.entity.dto.ExportReplyDto;
import com.dasoops.dasserver.plugin.loaj.entity.param.AddReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.DeleteReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.EditReplyParam;
import com.dasoops.dasserver.plugin.loaj.entity.param.GetReplyPageParam;
import com.dasoops.dasserver.plugin.loaj.entity.vo.GetReplyVo;
import com.dasoops.dasserver.plugin.loaj.service.ReplyService;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author DasoopsNicole@Gmail.com
 * @version 1.0.0
 * @title ReplyController
 * @classPath com.dasoops.dasserver.sys.user.controller.ReplyController
 * @date 2022/12/28
 * @description 回复 控制器
 */
@RestController
@RequestMapping("reply")
@Api(tags = "WM - reply")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("getReplyPage")
    @ApiOperation(value = "获取分页回复信息", notes = "获取分页回复信息")
    public PageResult<GetReplyVo> getReplyPage(GetReplyPageParam param) {
        IPage<GetReplyVo> replyDoPage = replyService.getReplyPageData(param);
        return PageResult.success(replyDoPage);
    }

    @PostMapping("editReply")
    @ApiOperation(value = "编辑回复", notes = "编辑回复")
    public SimpleResult editReply(@RequestBody EditReplyParam param) {
        replyService.editReply(param);
        return SimpleResult.success();
    }

    @GetMapping("getNextId")
    @ApiOperation(value = "获取下一个自增主键id", notes = "获取下一个自增主键id")
    public Result<GetNextIdVo> getNextId() {
        GetNextIdVo getNextIdVo = replyService.getNextId();
        return Result.success(getNextIdVo);
    }

    @PostMapping("addReply")
    @ApiOperation(value = "新增回复", notes = "新增回复")
    public SimpleResult addReply(@RequestBody AddReplyParam param) {
        replyService.addReply(param);
        return SimpleResult.success();
    }

    @PostMapping("deleteReply")
    @ApiOperation(value = "删除回复", notes = "删除回复")
    public SimpleResult deleteReply(@RequestBody DeleteReplyParam param) {
        replyService.deleteReply(param);
        return SimpleResult.success();
    }

    @GetMapping("exportAllReply")
    @ApiOperation(value = "导出所有回复", notes = "导出所有回复")
    public void exportAllReply(HttpServletResponse response) {
        List<ExportReplyDto> exportReplyDtoList = replyService.exportAllReply();
        ExcelUtil.Companion.simpleExport(response, exportReplyDtoList, "ReplyData");
    }


}
