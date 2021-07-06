package com.ll.redis.bean;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/7/6
 */
public class User {

    private String userName;

    private String userPassword;

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
