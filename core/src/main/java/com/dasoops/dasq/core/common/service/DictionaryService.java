package com.dasoops.dasq.core.common.service;

import com.dasoops.dasq.core.common.entity.po.Dictionary;
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
     * 初始化/更新 DictFatherDictCodeMap 数据至redis
     */
    void initOrUpdate();

    /**
     * 初始化 Version 数据至redis
     */
    void init();

    /**
     * 通过id获取字典
     *
     * @param fatherId 父亲id
     * @param dictCode dict编号
     * @return {@link String}
     */
    String getDictionaryById(Long fatherId, String dictCode);

    /**
     * 通过父id获取字典集合
     *
     * @param fatherId 父亲id
     * @return {@link Map}<{@link String}, {@link String}>
     */
    Map<String, String> getDictionaryMapByFatherId(Long fatherId);

    /**
     * 得到dictCode通过字典集合
     *
     * @param dictCode dict编号
     * @return {@link Map}<{@link String}, {@link String}>
     */
    Map<String, String> getDictionaryMapByDictCode(String dictCode);

    /**
     * 通过dictCode获得dictValue
     *
     * @param dictCode dict编号
     * @return {@link String}
     */
    String getDictValueByDictCode(String dictCode);

    /**
     * 根据dictCode获取id
     *
     * @param dictCode dict编号
     * @return {@link Long}
     */
    Long getIdByDictCode(String dictCode);

    /**
     * 更新版本
     *
     * @param commitCount 提交数
     */
    void updateVersion(Integer commitCount);

    /**
     * 获得版本
     *
     * @return {@link String}
     */
    String getVersion();

    /**
     * 获取云端最新版本
     *
     * @return {@link String}
     */
    String getCloudVersion();
}
