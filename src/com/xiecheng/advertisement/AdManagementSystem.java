package com.xiecheng.advertisement;

import java.util.ArrayList;
import java.util.List;

public class AdManagementSystem {
    private List<Admin> admins;
    private List<User> users;

    public AdManagementSystem() {
        this.admins = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<Admin> getAdmins() { return admins; }
    public List<User> getUsers() { return users; }
}
