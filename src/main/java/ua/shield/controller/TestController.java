package ua.shield.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sa on 30.03.17.
 */
@Controller
public class TestController {

    @RequestMapping("/test1")
     public void test1(){
        System.out.println("test");
     }
}
