package com.xiecheng.advertisement;

public class User {
    private String userID;
    private String name;
    private String preference;
    private String password;

    public User(String userID, String name, String preference, String password) {
        this.userID = userID;
        this.name = name;
        this.preference = preference;
        this.password = password;
    }

    // 登录方法
    public boolean login(String password) {
        return this.password.equals(password);
    }

    // 注册方法（仅展示示例，需与系统关联）
    public void register() {
        System.out.println("User registered: " + name);
    }

    // Getter 和 Setter
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPreference() { return preference; }
    public void setPreference(String preference) { this.preference = preference; }
}
