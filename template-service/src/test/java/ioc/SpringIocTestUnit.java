package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Map;

/**
 * Created by linshibiji on 2018/9/22.
 */
public class SpringIocTestUnit {

    private final static Logger LOGGER = LogManager.getLogger(SpringIocTestUnit.class);

    /**
     * Xml配置Beans默认属性
     */
    @Test
    public void testDefaultNameSpace() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("spring-ioc-default.xml");
        reader.loadBeanDefinitions(resource);
        DefaultNameSpaceBean bean = factory.getBean("defaultNameSpaceBean", DefaultNameSpaceBean.class);
        bean.execute();
        factory.destroySingleton("defaultNameSpaceBean");
    }

    /**
     * Xml配置Bean属性
     */
    @Test
    public void testBeanAttribute() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("spring-ioc-bean-attribute.xml");
        reader.loadBeanDefinitions(resource);
        SpringIocContext bean = factory.getBean("context", SpringIocContext.class);
        bean.doMessage();
    }

    /**
     * Xml配置Bean子标签
     */
    @Test
    public void testBeanProperty() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("spring-ioc-property.xml");
        reader.loadBeanDefinitions(resource);
        SpringIoc bean = factory.getBean("oneIoc", SpringIoc.class);
        bean.toString();
        factory.getBean("twoIoc");
        factory.getBean("springIoc");
        factory.getBean("iocPrototype");
        factory.getBean("lookup");
        factory.getBean("fourIoc");
    }

    @Test
    public void testBeanInterface() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        Resource resource = new ClassPathResource("spring-ioc-interface.xml");
        factory.addBeanPostProcessor(new CustomInstantiationAwareBeanPostProcessor());
        reader.loadBeanDefinitions(resource);
        Object obj01 = factory.getBean("springIocAware");
        Object obj02 = factory.getBean("factoryBean");
        Object obj03 = factory.getBean("&factoryBean");
        System.out.println(obj03);
    }

    /**
     * Spring 容器初始化时预备注入ApplicationContextAwareProcessor、ApplicationListenerDetector，其中ApplicationListenerDetector继承接口DestructionAwareBeanPostProcessor，MergedBeanDefinitionPostProcessor
     * 其中ApplicationContextAwareProcessor处理器负责把实现EnvironmentAware、EmbeddedValueResolverAware、ResourceLoaderAware、ApplicationEventPublisherAware、MessageSourceAware、ApplicationContextAware等接口的bean执行信息注入
     * ApplicationListenerDetector处理器负责把ApplicationListener类型的bean注入容器中，监听容器时间
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
    public void testFactoryMethod() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-ioc.xml");
        SpringIoc bean = ctx.getBean("threeIoc", SpringIoc.class);
        bean.getName();
    }

    @Test
    public void testLookupMethod() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-ioc.xml");
        LookupOverride bean = ctx.getBean("lookup", LookupOverride.class);
        SpringIoc b1 = bean.createSpringIoc();
        SpringIoc b2 = bean.createSpringIoc();
        SpringIoc b3 = bean.createSpringIoc();
        SpringIoc b4 = bean.createSpringIoc();
    }

    @Test
    public void testReplaceMethod() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring-ioc.xml");
        SpringIocContext bean = ctx.getBean("fourIoc", SpringIocContext.class);
        SpringIoc obj = bean.getSpringIoc();
        LOGGER.info(obj);
    }
}
