package aop;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTestUnit {

    @Test
    public void testJdkProxy() {
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{
                ProxyInterface.class
        }, new ProxyInvocationHandler(new ProxyInterfaceImpl()));
        proxy.execute();
    }

    /**
     * Spring Jar包已经包含了Cglib的所有代码
     */
    @Test
    public void testCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ProxyInterfaceImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                return methodProxy.invokeSuper(o, objects);
            }
        });
        ProxyInterfaceImpl obj = (ProxyInterfaceImpl) enhancer.create();
        obj.execute();
    }
}
