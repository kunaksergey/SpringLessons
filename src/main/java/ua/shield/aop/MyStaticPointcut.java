package ua.shield.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * Created by sa on 10.04.17.
 */
public class MyStaticPointcut extends DynamicMethodMatcherPointcut {
    Class myClass;
    Method myMethod;
    public MyStaticPointcut(Class myClass, Method myMethod) {
        this.myClass=myClass;
        this.myMethod=myMethod;
    }

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return myMethod.getName().equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
         return myMethod.getName().equals(method.getName());
    }

    @Override
    public ClassFilter getClassFilter() {
        return aClass -> aClass==myClass;
    }
}
