package com.example.demo.Model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservationdetail")
public class ReservationDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservationdetailId")
	public int reservationdetailId;

	@ManyToOne
	@JoinColumn(name = "reservation_id")
	public Reservation reservation_id;

	@Column(name = "date")
	public Date date;

	public Reservation getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(Reservation reservation_id) {
		this.reservation_id = reservation_id;
	}

	public int getReservationdetailId() {
		return reservationdetailId;
	}

	public void setReservationdetailId(int reservationdetailId) {
		this.reservationdetailId = reservationdetailId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
