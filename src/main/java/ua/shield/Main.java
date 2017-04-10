package ua.shield;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shield.aop.*;

/**
 * Created by sa on 23.03.17.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        CustomerBo target=new CustomerBoImpl();

        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(target);
        LogginAdviceBefore loginAdviceBefore=new LogginAdviceBefore();
        proxyFactory.addAdvice(loginAdviceBefore);
        CustomerBo customerBoProxy=(CustomerBo)proxyFactory.getProxy();

        ProxyFactory proxyFactoryWithAround=new ProxyFactory();
        proxyFactoryWithAround.setTarget(target);
        Pointcut pc=new MyStaticPointcut(CustomerBoImpl.class,CustomerBoImpl.class.getMethod("addCustomerAround",String.class));
        Advice advice=new LogginAdviceInterceptor();
        Advisor advisor=new DefaultPointcutAdvisor(pc,advice);
        proxyFactoryWithAround.addAdvisor(advisor);
        CustomerBo customerBoProxyWithAround=(CustomerBo)proxyFactoryWithAround.getProxy();

        System.out.println("----------------------");
        System.out.println("Without AOP:");
        target.addCustomer();
        System.out.println();
        System.out.println("With AOP -BEFORE:");
        customerBoProxy.addCustomer();
        System.out.println();
        System.out.println("With AOP -AROUND:");
        customerBoProxyWithAround.addCustomerAround("Sa");
        System.out.println("----------------------");
        System.out.println("--------TEST ANNOTATION---------");
        ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");
        CustomerBo customerBo = context.getBean("customerBo", CustomerBo.class);
        customerBo.addCustomer();

    }
}
