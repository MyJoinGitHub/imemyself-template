package aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvocationHandler implements InvocationHandler {

    private final static Logger LOGGER = LogManager.getLogger(ProxyInvocationHandler.class);

    private Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.info("Proxy Before .......");
        Object result = method.invoke(target, args);
        LOGGER.info("Proxy After .......");
        return result;
    }
}
