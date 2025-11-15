package com.connecthub.app.services;

import com.connecthub.app.models.RoomModel;
import com.connecthub.app.models.UserModel;
import com.connecthub.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Map<String,Object>> getAllUsers() {
        List<UserModel> users =  userRepository.findAll();
        if(users.isEmpty()) {
            Map<String,Object> resp = new HashMap<>();
            resp.put("error","Users not found");
            resp.put("status", HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
        }
        Map<String,Object> resp = new HashMap<>();
        resp.put("status", HttpStatus.OK.value());
        resp.put("data", users);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    public UserModel registerUser(UserModel user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String loginUser(UserModel user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated()) {
            return "Success";
        }
        return "Fail";
    }
    public UserModel getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
