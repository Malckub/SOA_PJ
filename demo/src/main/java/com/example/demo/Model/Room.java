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
    
    @Column(name = "Price")
    private String Price;
    // สร้างความสัมพันธ์กับ Entity RoomStatus
    @OneToOne
    @JoinColumn(name = "Status")
    private Roomstatus roomstatus;

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

	

	

	
}