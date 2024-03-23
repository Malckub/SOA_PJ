package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class roomcontroller {
	private final RoomRepository roomRepository;

	@Autowired
	public roomcontroller(RoomRepository roomkRepository, RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@GetMapping
	public List<Room> getAllRooms() {
		return (List<Room>) roomRepository.findAll();
	}

	@PostMapping
	public Room addBook(@RequestBody Room room) {
		return roomRepository.save(room);
	}

	@GetMapping("/{id}")
	public Room getBookById(@PathVariable int id) {
		return roomRepository.findById(id).orElse(null);
	}

}
