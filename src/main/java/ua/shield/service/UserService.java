package ua.shield.service;


import ua.shield.entity.User;

/**
 * Created by HillelNew8 on 05.04.2017.
 */
public interface UserService {
    User getUser(String login);
}
