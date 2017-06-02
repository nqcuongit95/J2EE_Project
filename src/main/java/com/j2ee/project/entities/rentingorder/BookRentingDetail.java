package com.j2ee.project.entities.rentingorder;

import java.sql.Timestamp;

public class BookRentingDetail {
	int id;	
	String note;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
