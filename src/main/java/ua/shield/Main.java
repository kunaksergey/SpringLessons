package ua.shield;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shield.aop.*;

/**
 * Created by sa on 23.03.17.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException {

//Target
        CustomerBo target=new CustomerBoImpl();
        ProxyFactory proxyFactory=new ProxyFactory();
        proxyFactory.setTarget(target);

//Advice Before for all Method
        LogginAdviceBefore loginAdviceBefore=new LogginAdviceBefore();
        proxyFactory.addAdvice(loginAdviceBefore);
        CustomerBo customerBo=(CustomerBo)proxyFactory.getProxy();
        customerBo.addCustomer();
        System.out.println();

//Advice Around for addCustomerAround
        Pointcut pc=new MyStaticPointcut(CustomerBoImpl.class,CustomerBoImpl.class.getMethod("addCustomerAround",String.class));
        Advice advice=new LogginAdviceInterceptor();
        Advisor advisor=new DefaultPointcutAdvisor(pc,advice);
        proxyFactory.removeAdvice(loginAdviceBefore);
        proxyFactory.addAdvisor(advisor);
        customerBo=(CustomerBo)proxyFactory.getProxy();
        customerBo.addCustomerAround("Sa");
        System.out.println();
//Using @Aspect
        ApplicationContext context=new ClassPathXmlApplicationContext("application-context.xml");

        customerBo = context.getBean("customerBo", CustomerBo.class);
        customerBo.addCustomer();
        System.out.println();


// Using Annotation Advice
        AnnotationMatchingPointcut pointcut=AnnotationMatchingPointcut.forMethodAnnotation(MyAopAnnotation.class);
        LogginAdviceAfter logginAdviceAfter=new LogginAdviceAfter();
        Advisor advisorAnnotation=new DefaultPointcutAdvisor(pointcut,logginAdviceAfter);

        proxyFactory.removeAdvice(loginAdviceBefore);
        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisorAnnotation);

        customerBo=(CustomerBo) proxyFactory.getProxy();
        customerBo.testAnnotationAdvice();

    }
}
