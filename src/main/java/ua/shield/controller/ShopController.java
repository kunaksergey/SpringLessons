package ua.shield.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.shield.Exception.ShopNotFoundException;
import ua.shield.entity.Shop;
import ua.shield.enums.UserRoleEnum;
import ua.shield.service.IShopService;
import ua.shield.service.ShopService;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

/**
 * Created by sa on 23.03.17.
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
    private static final String REDIRECT_URL="/shop/list";
    @Resource
    IShopService shopService;

    @RequestMapping(value = "/list",method = RequestMethod.GET )
    public String list(Model model){
        model.addAttribute("shopList",shopService.findAll());
        return REDIRECT_URL;
    }


    @RequestMapping(value = "/edit",method = RequestMethod.GET )

    public String edit(@RequestParam("id")Integer id,Model model){
        try {
            Shop shop=shopService.findById(id);
            model.addAttribute("shopOne",shop);
        } catch (ShopNotFoundException e) {
            return "error/404";
        }
        return "shop/edit";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET )
    @Secured({"ROLE_ADMIN","ROLE_USER"})
    //@PreAuthorize("hasRole('ADMIN')")
    //@PreAuthorize("isAuthenticated ()")
    public String add(Model model){
         Shop shop=new Shop();
         model.addAttribute("shopOne",shop);
         return "shop/edit";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST )
    public String save(@ModelAttribute("shopOne") Shop shop){
        shopService.shopCreated(shop);
        return "redirect:"+REDIRECT_URL;
    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET )
    public String delete(@RequestParam("id")Integer id){
        try {
            shopService.deleteShop(id);
        } catch (ShopNotFoundException e) {
            //NO action
        }
        return "redirect:"+REDIRECT_URL;
    }



}
