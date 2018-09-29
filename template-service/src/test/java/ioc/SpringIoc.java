package ioc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by linshibiji on 2018/9/22.
 */
public class SpringIoc {

    private final static Logger LOGGER = LogManager.getLogger(SpringIoc.class);

    private String name;

    public SpringIoc() {
        LOGGER.info("No parameter constructor........");
    }

    public SpringIoc(String name) {
        LOGGER.info("Has parameter constructor........");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SpringIoc{" +
                "name='" + name + '\'' +
                '}';
    }
}
