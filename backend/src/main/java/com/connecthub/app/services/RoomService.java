package com.connecthub.app.services;

import com.connecthub.app.models.RoomModel;
import com.connecthub.app.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomModel> getRooms(){
        return roomRepository.findAll();
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
