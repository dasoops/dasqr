//package com.dasoops.common.util;
//
//import cn.hutool.core.util.StrUtil;
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.ExcelWriter;
//import com.alibaba.excel.write.metadata.WriteSheet;
//import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
//import com.dasoops.common.exception.LogicException;
//import com.dasoops.common.util.entity.ExportInfo;
//import com.dasoops.common.util.entity.ExportExceptionEnum;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.poi.ss.formula.functions.T;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
///**
// * @author qml
// * @version 1.0.0
// * @ClassName ExcelUtil.java
// * @Description
// * @createTime 2020年04月01日 15:42:00
// */
//@Slf4j
//public class ExcelUtil {
//
//    /**
//     * xlsx的ContentType
//     */
//    public static final String XLSX_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
//
//
//    /**
//     * 简单导出(自动提取基类)
//     *
//     * @param response          response
//     * @param fileName          文件名称
//     * @param exportDataDtoList 导出数据集合
//     */
//    public static void simpleExport(HttpServletResponse response, List<?> exportDataDtoList, String fileName) {
//        if (exportDataDtoList.size() == 0) {
//            throw new LogicException(ExportExceptionEnum.DATA_NULL);
//        }
//
//        Class<?> clazz = exportDataDtoList.stream().findFirst().get().getClass();
//        ExcelUtil.Companion.simpleExport(response, exportDataDtoList, clazz, fileName, null);
//    }
//
//    /**
//     * 简单导出(自动提取基类)
//     *
//     * @param response          response
//     * @param fileName          文件名称
//     * @param exportDataDtoList 导出数据集合
//     */
//    public static void simpleExport(HttpServletResponse response, List<?> exportDataDtoList, Class<? extends T> clazz, String fileName) {
//        ExcelUtil.Companion.simpleExport(response, exportDataDtoList, clazz, fileName, null);
//    }
//
//    /**
//     * 简单出口
//     * 简单导出(自动提取基类)
//     *
//     * @param response          response
//     * @param fileName          文件名称
//     * @param exportDataDtoList 导出数据集合
//     * @param clazz             clazz
//     * @param sheet             表
//     */
//    public static <T> void simpleExport(HttpServletResponse response, List<? extends T> exportDataDtoList, Class<? extends T> clazz, String fileName, String sheet) {
//        final String defaultSheetName = "sheet1";
//
//        if (StrUtil.isBlank(sheet)) {
//            sheet = defaultSheetName;
//        }
//        ExcelUtil.export(response, clazz, exportDataDtoList, fileName, sheet);
//    }
//
//
//    /**
//     * 导出
//     *
//     * @param response response
//     * @param clazz    数据类对象
//     * @param fileName 文件名
//     * @param sheet    工作表名
//     * @param <T>      导出数据类型
//     */
//    public static <T> void export(HttpServletResponse response, Class<? extends T> clazz, List<? extends T> exportDataList, String fileName, String sheet) {
//        //文件编码,类型
//        response.setContentType(XLSX_CONTENT_TYPE);
//        response.setCharacterEncoding("utf-8");
//        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
//
//        //文件名
//        fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
//        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//
//        try (ExcelWriter writer = EasyExcel.write(response.getOutputStream()).registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).build()) {
//            ExcelUtil.sheetExport(writer, exportDataList, clazz, 0, sheet);
//        } catch (UnsupportedEncodingException e) {
//            log.error("导出部分url转码错误: ", e);
//            throw new LogicException(ExportExceptionEnum.URL_ENCODER_ERROR);
//        } catch (IOException e) {
//            log.error("io异常: ", e);
//            throw new LogicException(ExportExceptionEnum.DOWNLOAD_ERROR);
//        }
//    }
//
//    public static <T> void sheetExport(ExcelWriter writer, ExportInfo<?> exportInfo) {
//        WriteSheet writeSheet = EasyExcel.writerSheet(sheetNo, sheet).head(clazz).build();
//        writer.write(data, writeSheet);
//    }
//
//}
