package com.ravi.UserService.controller;

import com.ravi.UserService.entities.User;
import com.ravi.UserService.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    //create
    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
    //Single user get
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user = userService.getUser(userId);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    //All user get
    @GetMapping("/All")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUser();
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }
}
