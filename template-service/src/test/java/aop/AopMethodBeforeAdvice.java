package aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class AopMethodBeforeAdvice implements MethodBeforeAdvice,AfterReturningAdvice {

    private final static Logger LOGGER = LogManager.getLogger(AopMethodBeforeAdvice.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        LOGGER.info("AOP 前置增强");
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        LOGGER.info("AOP 后置增强");
    }
}
