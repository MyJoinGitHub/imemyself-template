package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractSpringIocContext {

    private final static Logger LOGGER = LogManager.getLogger(AbstractSpringIocContext.class);

    public AbstractSpringIocContext() {
        LOGGER.info("-----------AbstractSpringIocContext----------");
    }
}
