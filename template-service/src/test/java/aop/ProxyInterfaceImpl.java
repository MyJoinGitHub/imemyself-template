package aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProxyInterfaceImpl implements ProxyInterface {

    private final static Logger LOGGER = LogManager.getLogger(ProxyInterfaceImpl.class);

    @Override
    public boolean execute() {
        LOGGER.info("Realize Instance Execute!");
        return true;
    }
}
