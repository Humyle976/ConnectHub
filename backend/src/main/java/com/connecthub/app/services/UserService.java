package com.connecthub.app.services;

import com.connecthub.app.models.RoomModel;
import com.connecthub.app.models.UserModel;
import com.connecthub.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

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

    public ResponseEntity<Map<String,Object>> createUser(UserModel user) {

        try{
            UserModel createdUser = userRepository.save(user);
            Map<String, Object> resp = new HashMap<>();
            resp.put("status", HttpStatus.OK.value());
            resp.put("data", createdUser);
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }catch(Exception e){
            Map<String, Object> resp = new HashMap<>();
            resp.put("error", e.getMessage());
            resp.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String,Object>> getUserById(Integer id) {
        Optional<UserModel> userModel = userRepository.findById(id);
        if(userModel.isEmpty()){
            Map<String, Object> resp = new HashMap<>();
            resp.put("status", HttpStatus.NOT_FOUND.value());
            resp.put("error", "Room not found");
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        Map<String,Object> resp = new HashMap<>();
        resp.put("status", HttpStatus.OK.value());
        resp.put("data", userModel);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
