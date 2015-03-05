package com.qulix.ft.teachingSite;

public class User {

    public static final User ADMIN = new User("admin", "password", "Administrator");
    public static final User J_DOE = new User("jdoe", "password", "John Doe");

    private String userLoginName;
    private String password;
    private String name;

    public User(String userLoginName,String password, String name){
        this.userLoginName = userLoginName;
        this.password = password;
        this.name = name;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return getName();
    }
}
