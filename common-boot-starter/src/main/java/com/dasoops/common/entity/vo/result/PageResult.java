package com.dasoops.common.entity.vo.result;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dasoops.common.util.Convert;
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
public class PageResult<T> extends BaseResult {

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", notes = "返回数据", required = false)
    public List<T> data;

    /**
     * 总记录数
     */
    @ApiModelProperty(value = "总记录数", notes = "总记录数", required = false)
    public Integer total;

    /**
     * 成功
     *
     * @param dataList 数据集合
     * @param total    总计
     * @return {@link PageResult}<{@link T}>
     */
    public static <T> PageResult<T> success(List<T> dataList, Integer total) {
        PageResult<T> result = new PageResult<>();
        result.setCode(200);
        result.setMsg("请求成功");
        result.setData(dataList);
        result.setTotal(total);
        return result;
    }

    /**
     * 成功
     *
     * @param page 查询结果page对象
     * @return {@link PageResult}<{@link T}>
     */
    public static <T> PageResult<T> success(IPage<T> page) {
        PageResult<T> result = new PageResult<>();
        result.setCode(200);
        result.setMsg("请求成功");
        result.setData(page.getRecords());
        result.setTotal((int) page.getTotal());
        return result;
    }

    public static <T, T2> PageResult<T2> success(IPage<T> page, Class<T2> clazz) {
        return PageResult.success(Convert.to(page.getRecords(), clazz), (int) page.getTotal());
    }
}
