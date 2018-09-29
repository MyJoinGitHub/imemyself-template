package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by linshibiji on 2018/9/23.
 */
public class DependsOn {

    private final static Logger LOGGER = LogManager.getLogger(DependsOn.class);

    public DependsOn(){
        LOGGER.info("Construct DependsOn ......");
    }
    public void doSomething(){
        LOGGER.info("Deppends on do something .......");
    }
}
