package com.dasoops.dasserver.plugin.pluginwrapper;

import com.dasoops.common.util.Assert;
import com.dasoops.dasserver.cq.CqTemplate;
import com.dasoops.dasserver.cq.entity.event.message.MessageParam;
import com.dasoops.dasserver.cq.utils.CqCodeUtil;
import com.dasoops.minio.MinioTemplate;
import org.springframework.stereotype.Component;

/**
 * @Title: CbAssert
 * @ClassPath com.dasoops.dasserver.plugin.pluginwrapper.CbAssert
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/09
 * @Version 1.0.0
 * @Description: cb断言
 * @see Assert
 */
@Component
public class CbAssert extends Assert {

    private static MinioTemplate minioTemplate;

    public CbAssert(MinioTemplate minioTemplate) {
        CbAssert.minioTemplate = minioTemplate;
    }

    /**
     * 检查param和发送消息
     *
     * @param cqTemplate cq模板
     * @param param      param
     * @param params     参数个数
     * @return boolean
     */
    public static boolean checkParamAndSendMessage(CqTemplate cqTemplate, MessageParam param, Object... params) {
        return Assert.ifHasAnyNull(() -> {
            //发送嘲讽消息
            cqTemplate.sendMsg(param, "怎么这都不会");
            cqTemplate.sendMsg(param, CqCodeUtil.image(minioTemplate.buildImagePath("980d4eaa-a536-4f4c-b160-7e8a13f3ce04.jpg")));
        }, params);
    }
}
