package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by linshibiji on 2018/9/22.
 */
public class SpringIocContext {

    private final static Logger LOGGER = LogManager.getLogger(SpringIocContext.class);

    private SpringIoc springIoc;

    public SpringIocContext() {
        LOGGER.info("SpringIocContext constructor ......");
    }

    public void doMessage(){
        LOGGER.info(springIoc.getName());
    }

    public SpringIoc getSpringIoc() {
        return springIoc;
    }

    public void setSpringIoc(SpringIoc springIoc) {
        this.springIoc = springIoc;
    }
}
