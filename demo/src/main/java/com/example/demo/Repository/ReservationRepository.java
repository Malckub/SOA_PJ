package com.example.demo.Repository;

import com.example.demo.Model.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    // เพิ่มเมธอดหาห้องจาก ID ของห้อง
	Reservation findByreservationId(int re_id);
}
