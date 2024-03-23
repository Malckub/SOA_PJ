package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="room")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int RoomID;
	@Column
	private String Type;
	@Column
	private String Describe;
	@Column
	private int Status;
	@Column
	private int Price;
	@Column
	private int Roomsize;
	@Column
	private int Person;
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getDescribe() {
		return Describe;
	}
	public void setDescribe(String describe) {
		Describe = describe;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getRoomsize() {
		return Roomsize;
	}
	public void setRoomsize(int roomsize) {
		Roomsize = roomsize;
	}
	public int getPerson() {
		return Person;
	}
	public void setPerson(int person) {
		Person = person;
	}
	
}