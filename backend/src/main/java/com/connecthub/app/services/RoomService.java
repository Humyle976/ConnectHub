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

    public ResponseEntity<Map<String,Object>> createRoom(RoomModel roomModel){
        try{
            RoomModel savedRoom = roomRepository.save(roomModel);
            Map<String, Object> resp = new HashMap<>();
            resp.put("status", HttpStatus.OK.value());
            resp.put("data", savedRoom);
            return new ResponseEntity<>(resp, HttpStatus.OK);

        }catch(Exception e){
            Map<String, Object> resp = new HashMap<>();
            resp.put("error", e.getMessage());
            resp.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Map<String,Object>> deleteRoomById(Integer id){
        try {
            roomRepository.deleteById(id);
            Map<String, Object> resp = new HashMap<>();
            resp.put("status", HttpStatus.OK.value());
            return new ResponseEntity<>(resp, HttpStatus.OK);
        }catch (Exception e){
            Map<String, Object> resp = new HashMap<>();
            resp.put("error", e.getMessage());
            resp.put("status", HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Map<String,Object>> getRoomById(Integer id){
        Optional<RoomModel> roomModel = roomRepository.findById(id);
        if(roomModel.isEmpty()){
            Map<String, Object> resp = new HashMap<>();
            resp.put("status", HttpStatus.NOT_FOUND.value());
            resp.put("error", "Room not found");
            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
        Map<String,Object> resp = new HashMap<>();
        resp.put("status", HttpStatus.OK.value());
        resp.put("data", roomModel);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

}
