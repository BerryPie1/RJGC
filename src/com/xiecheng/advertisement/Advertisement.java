package com.xiecheng.advertisement;

import java.util.ArrayList;
import java.util.List;

public class Advertisement implements AdPushInterface{
    private String adID;
    private String name;
    private int priority;
    private String type;
    private List<UserGroup> userGroups;

    public Advertisement(String adID, String name, int priority, String type) {
        this.adID = adID;
        this.name = name;
        this.priority = priority;
        this.type = type;
        this.userGroups = new ArrayList<>();
    }

    @Override
    public void pushToUsers() {
        System.out.println("Pushing ad: " + name);
        for (UserGroup group : userGroups) {
            for (User user : group.getUsers()) {
                System.out.println("Ad sent to user: " + user.getName());
            }
        }
    }

    // Getter 和 Setter
    public String getAdID() { return adID; }
    public void setAdID(String adID) { this.adID = adID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public List<UserGroup> getUserGroups() { return userGroups; }
    public void addUserGroup(UserGroup group) { this.userGroups.add(group); }
}
