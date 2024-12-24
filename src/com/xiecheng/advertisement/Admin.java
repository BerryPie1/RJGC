package com.xiecheng.advertisement;

public class Admin {
    private String adminID;
    private String name;
    private String password;

    public Admin(String adminID, String name, String password) {
        this.adminID = adminID;
        this.name = name;
        this.password = password;
    }

    // 登录方法
    public boolean login(String password) {
        return this.password.equals(password);
    }

    // 注册方法
    public void register() {
        System.out.println("Admin registered: " + name);
    }

    // Getter 和 Setter
    public String getAdminID() { return adminID; }
    public void setAdminID(String adminID) { this.adminID = adminID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
