package com.dasoops.cq.conf;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.dasoops.cq.utils.EventUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Title: ParameterFillConfiguration
 * @ClassPath com.dasoops.dasq.core.common.conf.ParameterFillConfiguration
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/10/10
 * @Version 1.0.0
 * @Description: 参数自动填充
 * @see MetaObjectHandler
 */
@Component
public class ParameterFillConfiguration implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        this.strictInsertFill(metaObject, "createUser", String.class, String.valueOf(EventUtil.get().getAuthorId()));
        this.strictInsertFill(metaObject, "isDelete", String.class, "0");
        updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        this.strictUpdateFill(metaObject, "updateUser", String.class, String.valueOf(EventUtil.get().getAuthorId()));
    }

}