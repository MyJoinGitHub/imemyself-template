package com.imemyself.template.service.test;

import com.imemyself.template.service.DictionaryTypeService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by linshibiji on 2018/9/19.
 */
public class SpringTestUnit {

    @Test
    public void testOne() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:application.xml");
        DictionaryTypeService dictionaryTypeService = ctx.getBean("dictionaryTypeService", DictionaryTypeService.class);
        dictionaryTypeService.save(null);
        ctx.close();
    }

    @Test
    public void testTwo() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        DictionaryTypeService dictionaryTypeService = ctx.getBean("dictionaryTypeService", DictionaryTypeService.class);
        dictionaryTypeService.save(null);
    }


}
