package com.imemyself.template.domain;

public class DictionaryType extends BaseDomain {

    /**
     * 字典类型编码
     */
    private String dictionaryTypeCode;

    /**
     * 数据字典名称
     */
    private String dictionaryTypeName;

    public DictionaryType() {
    }

    public DictionaryType(String dictionaryTypeCode, String dictionaryTypeName) {
        this.dictionaryTypeCode = dictionaryTypeCode;
        this.dictionaryTypeName = dictionaryTypeName;
    }

    public String getDictionaryTypeCode() {
        return dictionaryTypeCode;
    }

    public void setDictionaryTypeCode(String dictionaryTypeCode) {
        this.dictionaryTypeCode = dictionaryTypeCode;
    }

    public String getDictionaryTypeName() {
        return dictionaryTypeName;
    }

    public void setDictionaryTypeName(String dictionaryTypeName) {
        this.dictionaryTypeName = dictionaryTypeName;
    }

    @Override
    public String toString() {
        return "DictionaryType{" +
                "id='" + getId() + '\'' +
                "dictionaryTypeCode='" + dictionaryTypeCode + '\'' +
                ", dictionaryTypeName='" + dictionaryTypeName + '\'' +
                '}';
    }
}
