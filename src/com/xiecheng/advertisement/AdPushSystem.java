package com.xiecheng.advertisement;

public class AdPushSystem {
    public static void main(String[] args) {
        // 创建用户和管理员
        User user1 = new User("U001", "Alice", "Tech", "pass123");
        User user2 = new User("U002", "Bob", "Travel", "pass456");
        Admin admin = new Admin("A001", "Admin1", "adminpass");

        // 创建用户组
        UserGroup group1 = new UserGroup("G001", "Tech Enthusiasts");
        group1.addUser(user1);
        group1.addUser(user2);

        // 创建广告
        Advertisement ad = new Advertisement("AD001", "Tech Promo", 1, "Technology");
        ad.addUserGroup(group1);

        // 广告推送
        ad.pushToUsers();

        // 管理系统
        AdManagementSystem system = new AdManagementSystem();
        system.addAdmin(admin);
        system.addUser(user1);
        system.addUser(user2);

        System.out.println("Ad management system initialized.");
    }
}