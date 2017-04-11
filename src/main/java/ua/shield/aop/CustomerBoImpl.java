package ua.shield.aop;

/**
 * Created by sa on 10.04.17.
 */
public class CustomerBoImpl implements CustomerBo {
    @Override
    public void addCustomer() {
        System.out.println("add Customer is running");
    }

    @Override
    public String addCustomerReturnValue() {
        System.out.println("addCustomerReturnValue is running");
        return "abc";
    }

    @Override
    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException is running");
        throw new Exception("Generic Error");
    }

    @Override
    public void addCustomerAround(String name) {
        System.out.println("addCustomerAround is running: "+name);
    }

    @Override
    @MyAopAnnotation
    public void testAnnotationAdvice() {
        System.out.println("Using my Annotation");
    }


}
