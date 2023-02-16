package com.dasoops.dasserver.cq.entity.dto.cq.retdata;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title FileData
 * @classPath com.dasoops.dasserver.cq.entity.retdata.FileData
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description 文件数据
 */
@Data
public class FileData {
    @JSONField(name = "file")
    private String file;
}
