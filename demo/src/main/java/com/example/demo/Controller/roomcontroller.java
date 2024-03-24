package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Repository.RoomRepository;

@Controller
@RequestMapping("/room")
public class roomcontroller {
	private final RoomRepository roomRepository;

	@Autowired
	public roomcontroller(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

	@GetMapping("/all")
	public String getAllRooms(Model model) {
		model.addAttribute("Room",roomRepository.findAll());
		return "room";
	}


}
