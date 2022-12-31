package com.dasoops.common.entity.vo.result;

import io.swagger.annotations.ApiModelProperty;
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

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", notes = "返回数据", example = "[{\"id\":1,\"name\":\"A\"},{\"id\":2,\"name\":\"B\"}]", required = true)
    public List<T> data;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数", notes = "总记录数", example = "100", required = true)
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
