package com.dasoops.dasserver.cq.entity.dto.cq.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

/**
 * @Title: CqFile
 * @ClassPath com.dasoops.dasserver.cq.entity.entity.CqFile
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/21
 * @Version 1.0.0
 * @Description: cq文件
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
