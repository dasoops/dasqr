package com.dasoops.common.entity.vo.result;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @Title: PageResult
 * @ClassPath cn.qiaoml.bean.vo.result.PageResult
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/11/30
 * @Version 1.0.0
 * @Description: 分页数据
 * @see Result
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EasyPageResult<T> extends BaseResult {

    public List<T> data;

    public Integer total;

    /**
     * 成功
     *
     * @param dataList 数据集合
     * @param total    总计
     * @return {@link EasyPageResult}<{@link T}>
     */
    public static <T> EasyPageResult<T> success(List<T> dataList, Integer total) {
        EasyPageResult<T> result = new EasyPageResult<>();
        result.setCode(200);
        result.setData(dataList);
        result.setTotal(total);
        return result;
    }
}
