package ua.shield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.shield.entity.User;
import ua.shield.enums.UserRoleEnum;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HillelNew8 on 05.04.2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user=userService.getUser("sa");
        Set<GrantedAuthority> roles=new HashSet<>();
        //user.getRoles().forEach(e-> roles.add(new SimpleGrantedAuthority(e.name())));
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.ADMIN.name()));
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),roles);
        return userDetails;
    }

}
