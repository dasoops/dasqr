package com.dasoops.common.entity.param.base;

import com.dasoops.common.entity.dbo.base.BaseDo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Title: BaseEditParam
 * @ClassPath com.dasoops.common.entity.param.base.BaseEditParam
 * @Author DasoopsNicole@Gmail.com
 * @Date 2023/01/12
 * @Version 1.0.0
 * @Description: 编辑param基类
 * @see BaseFastBuildParam
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseEditParam<T extends BaseDo> extends BaseEditAndDeleteParam<T> implements IBuildDo<T> {

}
