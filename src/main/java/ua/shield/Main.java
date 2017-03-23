package ua.shield;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shield.service.ShopService;

/**
 * Created by sa on 23.03.17.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("application-context.xml");
        ShopService shopService = context.getBean("shopService", ShopService.class);
        shopService.findAll().forEach(System.out::println);
    }
}
