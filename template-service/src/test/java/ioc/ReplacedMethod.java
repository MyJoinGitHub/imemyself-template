package ioc;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

/**
 * Created by linshibiji on 2018/9/23.
 */
public class ReplacedMethod implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return new SpringIoc("Replace method ......");
    }
}
