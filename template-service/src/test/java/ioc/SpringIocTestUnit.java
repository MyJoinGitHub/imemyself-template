package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by linshibiji on 2018/9/22.
 */
public class SpringIocTestUnit {

    private final static Logger LOGGER = LogManager.getLogger(SpringIocTestUnit.class);

    /**
     * Spring 容器初始化时预备注入ApplicationContextAwareProcessor、ApplicationListenerDetector，其中ApplicationListenerDetector继承接口DestructionAwareBeanPostProcessor，MergedBeanDefinitionPostProcessor
     */
    @Test
    public void testOne() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-ioc.xml");
        ctx.refresh();
        SpringIocContext bean = ctx.getBean("context", SpringIocContext.class);
        bean.doMessage();
        Map<String, SpringIoc> beanMap = ctx.getBeansOfType(SpringIoc.class);
        LOGGER.info(beanMap);
    }

    @Test
    public void testFactoryMethod(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-ioc.xml");
        SpringIoc bean = ctx.getBean("threeIoc", SpringIoc.class);
        bean.getName();
    }

    @Test
    public void testLookupMethod(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-ioc.xml");
        LookupOverride bean = ctx.getBean("lookup", LookupOverride.class);
        SpringIoc b1 = bean.createSpringIoc();
        SpringIoc b2 = bean.createSpringIoc();
        SpringIoc b3 = bean.createSpringIoc();
        SpringIoc b4 = bean.createSpringIoc();
    }

    @Test
    public void testReplaceMethod(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-ioc.xml");
        SpringIocContext bean = ctx.getBean("fourIoc", SpringIocContext.class);
        SpringIoc obj = bean.getSpringIoc();
        LOGGER.info(obj);
    }
}
