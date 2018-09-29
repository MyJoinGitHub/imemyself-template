package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * Created by linshibiji on 2018/9/24.
 */
public class IocBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    private final static Logger LOGGER = LogManager.getLogger(IocBeanDefinitionRegistryPostProcessor.class);

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        LOGGER.info("postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry)");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        LOGGER.info("postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)");
    }
}
