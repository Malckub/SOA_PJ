package com.example.demo.Controller;

import com.example.demo.Model.Room;
import com.example.demo.Repository.RoomRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class roomcontroller {

    private final RoomRepository roomRepository;
  
    
    @Autowired
    public roomcontroller(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @GetMapping("/room")
    public List<Room> getRoomWithStatus() {
        // ใช้เมธอด findByRoomId ใน Repository เพื่อหาข้อมูลห้องพร้อมสถานะ
        return roomRepository.findAll();
    }
    @GetMapping("/room/{roomId}")
    public Room getRoomWithStatus(@PathVariable int roomId) {
        // ใช้เมธอด findByRoomId ใน Repository เพื่อหาข้อมูลห้องพร้อมสถานะ
        return roomRepository.findByRoomId(roomId);
    }
}
