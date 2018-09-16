package com.imemyself.template.domain;

public class Dictionary extends BaseDomain {

    /**
     * 数据字典编码
     */
    private String dictionaryCode;

    /**
     * 数据字典名称
     */
    private String dictionaryName;

    /**
     * 数据字典类型
     *
     * @see
     */
    private Long dictionaryType;

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public Long getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(Long dictionaryType) {
        this.dictionaryType = dictionaryType;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "id='" + getId() + '\'' +
                "dictionaryCode='" + dictionaryCode + '\'' +
                ", dictionaryName='" + dictionaryName + '\'' +
                ", dictionaryType=" + dictionaryType +
                '}';
    }
}
