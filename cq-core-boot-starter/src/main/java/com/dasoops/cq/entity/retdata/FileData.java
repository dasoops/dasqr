package com.dasoops.cq.entity.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: FileData
 * @ClassPath com.dasoops.cq.entity.retdata.FileData
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: 文件数据
 */
@Data
public class FileData {
    @JSONField(name = "file")
    private String file;
}
