package ua.shield.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HillelNew8 on 05.04.2017.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value="loginIn",method = RequestMethod.GET)
    public String loginInPage(Model model){
        return "login/loginIn";
    }

    @RequestMapping(value="loginOut",method = RequestMethod.GET)
    public String loginOutPage(Model model){
        return "index";
    }
}
