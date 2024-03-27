package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Reservation;
import com.example.demo.Model.ReservationDetail;

@Repository
public interface ReservationDetailRepository extends JpaRepository<ReservationDetail, Integer>{
	
//	Reservation findByreservationdetailId(int reservationdetailId);
	ReservationDetail findByReservation_id(int reservationId);

}
