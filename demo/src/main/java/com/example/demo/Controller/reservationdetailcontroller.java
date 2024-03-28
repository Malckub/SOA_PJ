package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}
