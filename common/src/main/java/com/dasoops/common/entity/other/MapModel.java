package com.dasoops.common.entity.other;

import lombok.Data;

/**
 * @Title: MapModel
 * @ClassPath com.dasoops.common.entity.other.MapModel
 * @Author DasoopsNicole@Gmail.com
 * @Date 2022/12/15
 * @Version 1.0.0
 * @Description: Map对象, 为解决传递给前端Map结构数据时乱序问题
 */
@Data
public class MapModel<K, V> {

    /**
     * 键
     */
    private K key;

    /**
     * 值
     */
    private V value;
}
