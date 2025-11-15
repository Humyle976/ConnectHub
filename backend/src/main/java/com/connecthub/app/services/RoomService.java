package com.connecthub.app.services;

import com.connecthub.app.models.RoomModel;
import com.connecthub.app.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public ResponseEntity<Map<String,Object>> getRooms(){
        System.out.println("Hello");
        List<RoomModel> rooms = roomRepository.findAll();
        if (!rooms.isEmpty()) {
            Map<String,Object> response = new HashMap<>();
            response.put("status",HttpStatus.OK.value());
            response.put("data",rooms);
          return new ResponseEntity<>(response,HttpStatus.OK);
        }else {
            Map<String,Object> response = new HashMap<>();
            response.put("status", HttpStatus.NOT_FOUND.value());
            response.put("error", "No rooms found");
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
    }

    public RoomModel createRoom(RoomModel roomModel){
        return roomRepository.save(roomModel);
    }

    public void deleteRoomById(Integer id){
        roomRepository.deleteById(id);
    }

    public RoomModel getRoomById(Integer id){
        return roomRepository.findById(id).orElse(null);
    }

}
