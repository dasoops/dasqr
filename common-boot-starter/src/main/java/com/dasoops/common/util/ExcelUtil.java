package com.dasoops.common.util;

import cn.hutool.core.util.StrUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.dasoops.common.entity.enums.ExportExceptionEnum;
import com.dasoops.common.exception.LogicException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author qml
 * @version 1.0.0
 * @ClassName ExcelUtil.java
 * @Description
 * @createTime 2020年04月01日 15:42:00
 */
@Slf4j
public class ExcelUtil {

    /**
     * xlsx的ContentType
     */
    public static final String XLSX_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";


    /**
     * 简单导出(自动提取基类)
     *
     * @param response          response
     * @param fileName          文件名称
     * @param exportDataDtoList 导出数据集合
     */
    public static <T> void simpleExport(HttpServletResponse response, List<T> exportDataDtoList, String fileName) {
        if (exportDataDtoList.size() == 0) {
            throw new LogicException(ExportExceptionEnum.DATA_NULL);
        }

        Class<?> clazz = exportDataDtoList.stream().findFirst().get().getClass();
        ExcelUtil.simpleExport(response, clazz, exportDataDtoList, fileName);
    }

    /**
     * 简单导出
     *
     * @param response          response
     * @param clazz             数据类对象
     * @param fileName          文件名称
     * @param exportDataDtoList 导出数据集合
     */
    public static <T> void simpleExport(HttpServletResponse response, Class<? extends T> clazz, List<? extends T> exportDataDtoList, String fileName) {
        export(response, clazz, exportDataDtoList, fileName, null, null);
    }

    /**
     * 导出
     *
     * @param response         response
     * @param clazz            数据类对象
     * @param exportDataVoList 导出数据集合
     * @param fileName         文件名
     * @param sheet            工作表名
     * @param head             表头
     * @param <T>              导出数据类型
     */
    public static <T> void export(HttpServletResponse response, Class<? extends T> clazz, List<? extends T> exportDataVoList, String fileName, String sheet, List<List<String>> head) {
        try {

            final String defaultSheetName = "sheet1";

            //文件编码,类型
            response.setContentType(XLSX_CONTENT_TYPE);
            response.setCharacterEncoding("utf-8");
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");

            //文件名
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

            if (StrUtil.isBlank(sheet)) {
                sheet = defaultSheetName;
            }

            ExcelWriterSheetBuilder sheetBuilder = EasyExcel.write(response.getOutputStream(), clazz)
                    //自动列宽
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                    //工作表
                    .sheet(sheet);

            if (head != null) {
                sheetBuilder.head(head);
            }
            sheetBuilder.doWrite(exportDataVoList);
        } catch (UnsupportedEncodingException e) {
            log.error("导出部分url转码错误: ", e);
            throw new LogicException(ExportExceptionEnum.URL_ENCODER_ERROR);
        } catch (IOException e) {
            log.error("io异常: ", e);
            throw new LogicException(ExportExceptionEnum.DOWNLOAD_ERROR);
        }
    }


    /**
     * 导出
     *
     * @param response       response
     * @param exportDataList 导出数据集合
     * @param fileName       文件名
     * @param sheet          工作表名
     * @param head           表头
     */
    public static void export(HttpServletResponse response, List<List<?>> exportDataList, String fileName, String sheet, List<List<String>> head) {
        try {

            final String defaultSheetName = "sheet1";

            //文件编码,类型
            response.setContentType(XLSX_CONTENT_TYPE);
            response.setCharacterEncoding("utf-8");

            //文件名
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

            if (StrUtil.isBlank(sheet)) {
                sheet = defaultSheetName;
            }

            ExcelWriterSheetBuilder sheetBuilder = EasyExcel.write(response.getOutputStream())
                    //自动列宽
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                    //工作表
                    .sheet(sheet);

            if (head != null) {
                sheetBuilder.head(head);
            }
            sheetBuilder.doWrite(exportDataList);
        } catch (UnsupportedEncodingException e) {
            log.error("导出部分url转码错误: ", e);
            throw new LogicException(ExportExceptionEnum.URL_ENCODER_ERROR);
        } catch (IOException e) {
            log.error("io异常: ", e);
            throw new LogicException(ExportExceptionEnum.DOWNLOAD_ERROR);
        }

    }
}
