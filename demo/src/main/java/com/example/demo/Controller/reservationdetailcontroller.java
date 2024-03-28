package com.example.demo.Controller;

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

		return reservationdetail.findAll();
	}
	
	@GetMapping("/reservationdetail/{id}")
	public ReservationDetail getReservationDetailById(@PathVariable int id) {
		return reservationdetail.findByreservationdetailId(id);
	}

	@PostMapping(value = "/reservationdetail/create", consumes = "application/json")
	public ReservationDetail addReservationDetail(@RequestBody ReservationDetail reservationDetail) {

		return reservationdetail.save(reservationDetail);
	}

	@DeleteMapping("/reservationdetail/delete/{id}")
	public void deleteReservationDetail(@PathVariable int id) {
		reservationdetail.deleteById(id);
	}
	
	@PutMapping("/reservationdetail/{id}")
    public ResponseEntity<?> updateReservationDetail(@PathVariable int id, @RequestBody ReservationDetail newReservationDetail) {
        Optional<ReservationDetail> optionalReservationDetail = reservationdetail.findById(id);
        if (optionalReservationDetail.isPresent()) {
            ReservationDetail existingReservationDetail = optionalReservationDetail.get();
            existingReservationDetail.setReservation_id(newReservationDetail.getReservation_id());
            existingReservationDetail.setDate(newReservationDetail.getDate());
            
            ReservationDetail updatedReservationDetail = reservationdetail.save(existingReservationDetail);
            return ResponseEntity.ok(updatedReservationDetail);
        } else {
            // ถ้าไม่พบ Reservation ที่ต้องการอัปเดต ส่งข้อความว่างคืนไป
            return ResponseEntity.notFound().build();
        }
    }
	
}
