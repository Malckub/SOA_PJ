package com.example.demo.Repository;

import com.example.demo.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	// เพิ่มเมธอดหาห้องจาก ID ของห้อง
	Room findByRoomId(int roomId);

	void deleteById(int roomId);
}
