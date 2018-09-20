package com.imemyself.template.service.test;

import com.imemyself.template.service.DictionaryTypeService;
import com.imemyself.template.service.impl.DictionaryTypeServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by linshibiji on 2018/9/20.
 */
@Configurable
public class SpringConfig {

    @Bean
    public DictionaryTypeService dictionaryTypeService(){
        return new DictionaryTypeServiceImpl();
    }
}
