package com.connecthub.app.controllers;

import com.connecthub.app.models.RoomModel;
import com.connecthub.app.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public List<RoomModel> getRooms() {
        return roomService.getRooms();
    }

    @PostMapping("/room")
    public RoomModel createRoom(@RequestBody RoomModel roomModel) {
        return roomService.createRoom(roomModel);
    }

    @DeleteMapping("/room/{roomId}")
    public void deleteRoom(@PathVariable("roomId") Integer roomId) {
        roomService.deleteRoomById(roomId);
    }

    @GetMapping("/room/{roomId}")
    public RoomModel getRoom(@PathVariable("roomId") Integer roomId) {
        return roomService.getRoomById(roomId);
    }
}
