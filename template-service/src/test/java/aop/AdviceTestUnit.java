package aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-aop-advice.xml")
public class AdviceTestUnit {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void testBefore() throws ClassNotFoundException {
        AopService target = new AopServiceImpl();
        AopMethodBeforeAdvice beforeAdvice = new AopMethodBeforeAdvice();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(beforeAdvice);
        AopService aopService = (AopService) proxyFactory.getProxy();
        aopService.before();
        aopService.after();
    }

    @Test
    public void testXmlBefore() {
        Assert.notNull(ctx, "");
        AopService obj = (AopService) ctx.getBean("beforeAdvice");
        obj.before();
        obj.after();
    }
}
