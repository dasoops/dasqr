package com.dasoops.common.util;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import com.dasoops.common.entity.dbo.base.BaseDo;
import com.dasoops.common.entity.vo.base.BaseVo;

/**
 * @Title: VoBuilder
 * @ClassPath com.dasoops.common.util.VoBuilder
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/26
 * @Version 1.0.0
 * @Description: vo构建器
 */
public class VoBuilder {

    public static <R extends BaseVo, D extends BaseDo> R build(Class<R> voClass, D baseDo) {
        R r = ReflectUtil.newInstance(voClass);
        BeanUtil.copyProperties(baseDo, r);
        //todo 别名注解支持
        return r;
    }


}
