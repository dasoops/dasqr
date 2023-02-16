package com.dasoops.dasserver.plugin.image.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dasoops.common.entity.result.PageResult;
import com.dasoops.common.entity.result.Result;
import com.dasoops.common.entity.result.SimpleResult;
import com.dasoops.common.util.ExcelUtil;
import com.dasoops.dasserver.plugin.image.entity.dto.ExportImageInfoDto;
import com.dasoops.dasserver.plugin.image.entity.param.*;
import com.dasoops.dasserver.plugin.image.entity.vo.GetFantasyKeywordVo;
import com.dasoops.dasserver.plugin.image.entity.vo.GetImageVo;
import com.dasoops.dasserver.plugin.image.entity.vo.UploadImageVo;
import com.dasoops.dasserver.plugin.image.service.ImageService;
import com.dasoops.dasserver.plugin.webmanager.entity.vo.GetNextIdVo;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @title ImageController
 * @classPath com.dasoops.dasserver.plugin.image.controller.ImageController
 * @author DasoopsNicole@Gmail.com
 * @date 2022/12/31
 * @version 1.0.0
 * @description 图片Controller
 */
@RestController
@RequestMapping("image")
@Api(tags = "PLUGIN - IMAGE")
@ApiSupport(author = "DasoopsNicole@gmail.com")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("getImageInfoPage")
    @ApiOperation(value = "获取图片分页信息", notes = "获取图片分页信息")
    public PageResult<GetImageVo> getImageInfoPage(GetImageInfoPageParam param) {
        IPage<GetImageVo> imageDoPage = imageService.getImageInfoPage(param);
        return PageResult.success(imageDoPage, GetImageVo.class);
    }

    @GetMapping("getFantasyKeyword")
    @ApiOperation(value = "获取联想关键词", notes = "获取联想关键词")
    public Result<GetFantasyKeywordVo> getFantasyKeyword(GetFantasyKeywordParam param) {
        GetFantasyKeywordVo vo = imageService.getFantasyKeyword4Cache(param);
        return Result.success(vo);
    }

    @PostMapping("editImageInfo")
    @ApiOperation(value = "编辑图片信息", notes = "编辑图片信息")
    public SimpleResult editImageInfo(@RequestBody EditImageInfoParam param) {
        imageService.editImageInfo(param);
        return SimpleResult.success();
    }

    @GetMapping("getNextId")
    @ApiOperation(value = "获取下一个自增主键id", notes = "获取下一个自增主键id")
    public Result<GetNextIdVo> getNextId() {
        GetNextIdVo getNextIdVo = imageService.getNextId();
        return Result.success(getNextIdVo);
    }

    @PostMapping("addImage")
    @ApiOperation(value = "新增图片", notes = "新增图片")
    public SimpleResult addImage(@RequestBody AddImageParam param) {
        imageService.addImage(param);
        return SimpleResult.success();
    }

    @PostMapping("deleteImage")
    @ApiOperation(value = "删除图片", notes = "删除图片")
    public SimpleResult deleteImage(@RequestBody DeleteImageParam param) {
        imageService.deleteImage(param);
        return SimpleResult.success();
    }

    @GetMapping("exportAllImageInfo")
    @ApiOperation(value = "导出所有图片信息", notes = "导出所有图片信息")
    public void exportAllImageInfo(HttpServletResponse response) {
        List<ExportImageInfoDto> exportImageInfoDtoList = imageService.exportAllImageInfo();
        ExcelUtil.Companion.simpleExport(response, exportImageInfoDtoList, "imageInfo");
    }

    @PostMapping("uploadImage")
    @ApiOperation(value = "上传图片", notes = "上传图片")
    public Result<UploadImageVo> uploadImage(MultipartFile file) {
        UploadImageVo uploadImageVo = imageService.uploadImage(file);
        return Result.success(uploadImageVo);
    }

}
