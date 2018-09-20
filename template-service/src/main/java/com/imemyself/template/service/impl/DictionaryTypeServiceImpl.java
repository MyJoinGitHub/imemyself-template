package com.imemyself.template.service.impl;

import com.imemyself.template.domain.DictionaryType;
import com.imemyself.template.service.DictionaryTypeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by linshibiji on 2018/9/19.
 */
public class DictionaryTypeServiceImpl implements DictionaryTypeService {

    private static Logger logger=LogManager.getLogger(DictionaryTypeServiceImpl.class);

    @Override
    public Boolean save(DictionaryType dictionaryType) {
        logger.info("Hello world!");
        return null;
    }

    private DictionaryType dictionaryType;

    public void setDictionaryType(DictionaryType dictionaryType) {
        this.dictionaryType = dictionaryType;
    }

    public void initMethod(){
        logger.info("Spring init method!");
    }

    public void destroyMethod(){
        logger.info("Spring destroyMethod!");
    }
}
