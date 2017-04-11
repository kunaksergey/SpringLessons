package ua.shield.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by sa on 10.04.17.
 */
public class LogginAdviceInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("around method --before--");
        Object object=methodInvocation.proceed();
        System.out.println("around method --after--");
        return object;
    }
}
