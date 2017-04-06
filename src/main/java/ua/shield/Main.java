package ua.shield;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shield.service.IShopService;

/**
 * Created by sa on 23.03.17.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("application-context.xml");
        IShopService shopService = context.getBean("shopService", IShopService.class);
        shopService.findAll().forEach(System.out::println);

    }
}
