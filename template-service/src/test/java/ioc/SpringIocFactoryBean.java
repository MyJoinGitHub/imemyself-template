package ioc;

import org.springframework.beans.factory.FactoryBean;

public class SpringIocFactoryBean implements FactoryBean<SpringIoc> {

    @Override
    public SpringIoc getObject() throws Exception {
        return new SpringIoc();
    }

    @Override
    public Class<?> getObjectType() {
        return SpringIoc.class;
    }
}
