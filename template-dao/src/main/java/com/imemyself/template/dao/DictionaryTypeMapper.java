package com.imemyself.template.dao;

import com.imemyself.template.domain.DictionaryType;

import java.util.List;

public interface DictionaryTypeMapper {

    /**
     * 保存字典类型
     * @param dictionaryType
     * @return
     */
    Integer save(DictionaryType dictionaryType);

    /**
     * 根据实体的id标识更新各个非空属性
     * @param dictionaryType
     * @return
     */
    Integer update(DictionaryType dictionaryType);

    /**
     * 删除指定标识的实体记录
     * @param id
     * @return
     */
    Integer delete(Long id);

    /**
     * 查询指定标识的记录
     * @param id
     * @return
     */
    DictionaryType findOne(Long id);

    /**
     * 根据参数条件查询字典类型记录
     * @param dictionaryType
     * @return
     */
    List<DictionaryType> find(DictionaryType dictionaryType);
}
