package com.example.newapp2;

import java.util.ArrayList;
import java.util.List;

public class UsersLst {
    private static UsersLst instance;
    public UsersLst getInstance(){
        if (instance == null) {
            instance = new UsersLst();
        }
        return  instance;
    }

    private final List<User> userList = new ArrayList<>();

    public boolean hasUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return  false;
    }

    public void addUser(User user) {
        if (this.hasUser(user.getUsername())) {
            // TODO: about
        }
        this.userList.add(user);
    }

    public boolean hasUserInfo(User user) {
        for (User u : userList) {
            if (user.isSameUser(u)) {
                return true;
            }
        }
        return  false;
    }
}
