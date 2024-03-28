package com.example.demo.Controller;

import com.example.demo.Model.Reservation;
import com.example.demo.Model.ReservationDetail;
import com.example.demo.Model.Room;
import com.example.demo.Repository.RoomRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping(value = "/room/create", consumes = "application/json")
	public Room addReservation(@RequestBody Room room1) {

		return roomRepository.save(room1);
	}

	@DeleteMapping("/room/delete/{roomId}")
	public void deleteRoom(@PathVariable int roomId) {
		// เรียกใช้เมธอด deleteById เพื่อลบห้องโดยระบุ ID
		roomRepository.deleteById(roomId);
	}
	
	@PutMapping("/room/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable int id, @RequestBody Room newRoom) {
        Optional<Room> optionalRoom = roomRepository.findById(id);
        if (optionalRoom.isPresent()) {
            Room existingRoom = optionalRoom.get();
            existingRoom.setType(newRoom.getType());
            existingRoom.setDescibe(newRoom.getDescibe());
            existingRoom.setRoomstatus(newRoom.getRoomstatus());
            existingRoom.setRoomsize(newRoom.getRoomsize());
            existingRoom.setPerson(newRoom.getPerson());
            existingRoom.setPrice(newRoom.getPrice());
            
            Room updatedRoom = roomRepository.save(existingRoom);
            return ResponseEntity.ok(updatedRoom);
        } else {
            // ถ้าไม่พบ Reservation ที่ต้องการอัปเดต ส่งข้อความว่างคืนไป
            return ResponseEntity.notFound().build();
        }
    }
}
