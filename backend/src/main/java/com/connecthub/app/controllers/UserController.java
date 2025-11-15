package com.connecthub.app.controllers;

import com.connecthub.app.models.UserModel;
import com.connecthub.app.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Map<String,Object>> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Map<String,Object>> getUser(@PathVariable("userId") Integer userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/user")
    public ResponseEntity<Map<String,Object>> createUser(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }
}
