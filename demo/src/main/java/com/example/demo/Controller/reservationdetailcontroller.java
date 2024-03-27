package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ReservationDetail;
import com.example.demo.Repository.ReservationDetailRepository;

@RestController
public class reservationdetailcontroller {
	
	private final ReservationDetailRepository reservationdetailRepository;
	
	@Autowired
    public reservationdetailcontroller(ReservationDetailRepository reservationdetailRepository) {
        this.reservationdetailRepository = reservationdetailRepository;
    }
	
	@GetMapping("/reservationdetail")
    public List<ReservationDetail> getAllreservationdetail() {
        // ใช้เมธอด findByRoomId ใน Repository เพื่อหาข้อมูลห้องพร้อมสถานะ
        return reservationdetailRepository.findAll();
    }
	
<<<<<<< Updated upstream
	@PostMapping("/reservationdetail")
	public ResponseEntity<ReservationDetail> createReservationDetail(@RequestBody ReservationDetail reservationDetail) {
	    try {
	        ReservationDetail createdReservationDetail = reservationdetailRepository.save(reservationDetail);
	        return new ResponseEntity<>(createdReservationDetail, HttpStatus.CREATED);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	
=======
	@PostMapping(value = "/reservationdetail/create", consumes = "application/json")
	public ReservationDetail addReservationDetail(@RequestBody ReservationDetail reservationDetail) {
		// ทำการเพิ่มข้อมูลการจองลงในฐานข้อมูล
		return reservationdetail.save(reservationDetail);
	}
>>>>>>> Stashed changes
}
