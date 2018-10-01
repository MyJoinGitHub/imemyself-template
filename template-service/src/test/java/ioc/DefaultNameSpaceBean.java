package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DefaultNameSpaceBean {

    private final static Logger LOGGER = LogManager.getLogger(DefaultNameSpaceBean.class);


    public void defaultInitMethod() {
        LOGGER.info("------------ Default Init Method ------------");
    }

    public void defaultDestroyMethod() {
        LOGGER.info("------------ Default Destroy Method ------------");
    }

    public void initMethod() {
        LOGGER.info("------------ Init Method ------------");
    }

    public void destroyMethod() {
        LOGGER.info("------------ Destroy Method ------------");
    }

    public void execute() {
        LOGGER.info("------------ Execute Method ------------");
    }

}
