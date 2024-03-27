package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RoomID")
    private int roomId;

    @Column(name = "Type")
    private String type;
    
    @Column(name = "Describe")
    private String descibe;
    
    @Column(name = "Price")
    private int Price;
    // สร้างความสัมพันธ์กับ Entity RoomStatus
    @OneToOne
    @JoinColumn(name = "Status")
    private Roomstatus roomstatus;
    
    @Column(name = "room_size")
    private int roomsize;
    
    @Column(name = "Person")
    private int person;

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Roomstatus getRoomstatus() {
		return roomstatus;
	}

	public void setRoomstatus(Roomstatus roomstatus) {
		this.roomstatus = roomstatus;
	}



	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getRoomsize() {
		return roomsize;
	}

	public void setRoomsize(int roomsize) {
		this.roomsize = roomsize;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public String getDescibe() {
		return descibe;
	}

	public void setDescibe(String descibe) {
		this.descibe = descibe;
	}

	
}