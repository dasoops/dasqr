package com.dasoops.dasserver.cq.entity.dto.cq.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @title: CqFile
 * @classPath com.dasoops.dasserver.cq.entity.entity.CqFile
 * @author DasoopsNicole@Gmail.com
 * @date 2022/10/21
 * @version 1.0.0
 * @description cq文件
 */
@Data
public class CqFile {
    @JSONField(name = "id")
    private String id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "size")
    private long size;
    @JSONField(name = "busid")
    private long busid;
}
