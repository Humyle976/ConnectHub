package com.connecthub.app.controllers;

import com.connecthub.app.models.UserModel;
import com.connecthub.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public UserModel getUser(@PathVariable("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/user")
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }
}
