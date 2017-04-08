package ua.shield.enums;

/**
 * Created by HillelNew8 on 05.04.2017.
 */
public enum UserRoleEnum {
    ADMIN,USER,ANONYMUS;
     UserRoleEnum() {
    }
    public String getName(){
        return this.name();
    }
}
