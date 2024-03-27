package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Reservation;
import com.example.demo.Model.ReservationDetail;
import com.example.demo.Repository.ReservationDetailRepository;
import com.example.demo.Repository.ReservationRepository;

@RestController
public class reservationdetailcontroller {
	
	private final ReservationDetailRepository reservationdetail;
	
	@Autowired
    public reservationdetailcontroller(ReservationDetailRepository reservationdetailRepository) {
        this.reservationdetail = reservationdetailRepository;
    }
	
	@GetMapping("/reservationdetail")
    public List<ReservationDetail> getAllreservationdetail() {
        // ใช้เมธอด findByRoomId ใน Repository เพื่อหาข้อมูลห้องพร้อมสถานะ
        return reservationdetail.findAll();
    }
	
	@PostMapping(value = "/reservationdetail/create", consumes = "application/json")
	public ReservationDetail addReservationDetail(@RequestBody ReservationDetail reservationDetail) {
		// ทำการเพิ่มข้อมูลการจองลงในฐานข้อมูล
		return reservationdetail.save(reservationDetail);
	}
}
