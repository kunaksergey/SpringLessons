package ua.shield;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.shield.entity.User;
import ua.shield.service.IShopService;
import ua.shield.service.UserService;

/**
 * Created by sa on 23.03.17.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("application-context.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user=userService.getUser("sa");
        System.out.println(user);

    }
}
