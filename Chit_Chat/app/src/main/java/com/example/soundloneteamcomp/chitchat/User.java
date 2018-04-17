package com.example.soundloneteamcomp.chitchat;

public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private Boolean isMale;
    private String email;
    private String phone;
    private String address;
    private String password;
    private static String userId;
    private static int id=0;

    public User(String userName, String firstName, String lastName, Boolean isMale, String email, String phone, String address, String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMale = isMale;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public String getUserName() {
        return userName;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId() {
        this.userId = "USER" + id++;
    }
}
