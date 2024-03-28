package com.example.demo.Controller;

import com.example.demo.Model.Reservation;
import com.example.demo.Model.Room;
import com.example.demo.Repository.ReservationRepository;

import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class reservationcontroller {

	private final ReservationRepository reservation;

	@Autowired
	public reservationcontroller(ReservationRepository reservationRepository) {
		this.reservation = reservationRepository;
	}

	@GetMapping("/reservation")
	public List<Reservation> getAllreservation() {
		// ใช้เมธอด findByRoomId ใน Repository เพื่อหาข้อมูลห้องพร้อมสถานะ
		return reservation.findAll();
	}

	@GetMapping("/reservation/{re_id}")
	public Reservation getreservation(@PathVariable int re_id) {
		// ใช้เมธอด findByRoomId ใน Repository เพื่อหาข้อมูลห้องพร้อมสถานะ
		return reservation.findByreservationId(re_id);
	}

	@GetMapping("/reservation/{re_id}/{email}")
	public Reservation getReservationByReservationIdAndEmail(@PathVariable int re_id, @PathVariable String email) {
		return reservation.findByReservationIdAndEmail(re_id, email);
	}

	@PostMapping(value = "/reservation/create", consumes = "application/json")
	public Reservation addReservation(@RequestBody Reservation reservation1) {
		// ทำการเพิ่มข้อมูลการจองลงในฐานข้อมูล
		return reservation.save(reservation1);
	}
}
