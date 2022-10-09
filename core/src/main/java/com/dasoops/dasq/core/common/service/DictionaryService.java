package com.dasoops.dasq.core.common.service;

import com.dasoops.dasq.core.common.entity.pojo.Dictionary;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author Administrator
 * @description 针对表【TB_SYS_DICTIONARY】的数据库操作Service
 * @createDate 2022-10-09 11:10:23
 */
public interface DictionaryService extends IService<Dictionary> {

    /**
     * 初始化/更新 DictionaryTreeData 数据至redis
     */
    void initOrUpdateDictTreeData2Redis();


    /**
     * 初始化/更新 DictFatherDictCodeMap 数据至redis
     */
    void initOrUpdateDictFatherDictCodeMap2Redis();

    /**
     * 通过id获取字典
     *
     * @param fatherId 父亲id
     * @param dictCode dict编号
     * @return {@link String}
     */
    String getDictionaryById(Long fatherId, String dictCode);

    /**
     * 被通过父id获取字典集合
     *
     * @param fatherId 父亲id
     * @return {@link Map}<{@link String}, {@link String}>
     */
    Map<String, String> getDictionaryMapByFatherId(Long fatherId);

    /**
     * 根据dictCode获取id
     *
     * @param dictCode dict编号
     * @return {@link Long}
     */
    Long getIdByDictCode(String dictCode);
}
