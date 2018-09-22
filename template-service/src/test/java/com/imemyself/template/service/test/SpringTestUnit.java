package com.imemyself.template.service.test;

import com.imemyself.template.service.DictionaryTypeService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by linshibiji on 2018/9/19.
 */
public class SpringTestUnit {

    @Test
    public void testOne() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath*:application.xml");
        DictionaryTypeService dictionaryTypeService = ctx.getBean("dictionaryTypeService", DictionaryTypeService.class);
        dictionaryTypeService.save(null);
        String[] names = ctx.getBeanDefinitionNames();
        ctx.close();
    }

    @Test
    public void testTwo() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        DictionaryTypeService dictionaryTypeService = ctx.getBean("dictionaryTypeService", DictionaryTypeService.class);
        dictionaryTypeService.save(null);
    }


}
