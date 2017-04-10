package ua.shield.service;

import org.springframework.stereotype.Service;
import ua.shield.entity.User;
import ua.shield.enums.UserRoleEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HillelNew8 on 05.04.2017.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Override
    public User getUser(String login) {
        User user=new User();
        user.setLogin(login);
        user.setPassword("7110eda4d09e062aa5e4a390b0a572ac0d2c0220");
        Set<UserRoleEnum> roleSet=new HashSet<>();
        roleSet.add(UserRoleEnum.ROLE_USER);
        roleSet.add(UserRoleEnum.ROLE_ADMIN);
        user.setRoles(roleSet);
        return user;
    }
}
