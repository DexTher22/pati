package com.example.models;

import java.util.List;

public class Auth {
    public static boolean isValid(String name, String pass) {
        List<User> userList = Storage.readContent();
        boolean valid = false;
        for(User user: userList){
            if(user.getUser().equals(name) && user.getPass().equals(pass) && user.getRole().equals("admin")){
                valid = true;
            }
        }
        return valid;
    }
}
