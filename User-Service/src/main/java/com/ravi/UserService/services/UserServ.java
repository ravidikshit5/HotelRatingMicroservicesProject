package com.ravi.UserService.services;

import com.ravi.UserService.entities.User;

import java.util.List;

public interface UserServ {
    //save User

    User saveUser(User user);
    //get all user
    List<User> getAllUser();
    //get user by ID
    User getUser(String userId);
}
