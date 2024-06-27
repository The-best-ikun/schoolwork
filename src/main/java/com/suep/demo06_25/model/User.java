package com.suep.demo06_25.model;

public class User {
    private String id;
    private String password;
    private String email;
    private String phone;
    private String identity; // 学生、老师或管理员

    public User(String id, String password, String email, String phone, String identity) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.identity = identity;
    }

    // Getter和Setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}