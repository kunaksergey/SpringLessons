package ua.shield.aop;

/**
 * Created by sa on 10.04.17.
 */
public interface CustomerBo {
    void addCustomer();
    String addCustomerReturnValue();
    void addCustomerThrowException() throws Exception;
    void addCustomerAround(String name);
     void testAnnotationAdvice() ;
}
