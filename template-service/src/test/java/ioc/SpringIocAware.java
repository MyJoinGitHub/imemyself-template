package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class SpringIocAware implements EnvironmentAware,BeanFactoryAware,BeanNameAware {

    private final static Logger LOGGER = LogManager.getLogger(SpringIocAware.class);

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        LOGGER.info("=========BeanFactoryAware.setBeanFactory========");
    }

    @Override
    public void setBeanName(String name) {
        LOGGER.info("=========BeanNameAware.setBeanName========");
    }

    @Override
    public void setEnvironment(Environment environment) {
        LOGGER.info("=========EnvironmentAware.setEnvironment========");

    }
}
