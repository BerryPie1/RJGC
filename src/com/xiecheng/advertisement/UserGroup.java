package com.xiecheng.advertisement;

import java.util.ArrayList;
import java.util.List;

public class UserGroup {
    private String userGroupID;
    private String name;
    private List<User> users;

    public UserGroup(String userGroupID, String name) {
        this.userGroupID = userGroupID;
        this.name = name;
        this.users = new ArrayList<>();
    }

    // 添加用户到用户组
    public void addUser(User user) {
        users.add(user);
    }

    // Getter 和 Setter
    public String getUserGroupID() { return userGroupID; }
    public void setUserGroupID(String userGroupID) { this.userGroupID = userGroupID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<User> getUsers() { return users; }
}
