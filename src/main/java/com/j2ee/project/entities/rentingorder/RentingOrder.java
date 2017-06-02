package com.j2ee.project.entities.rentingorder;

import java.util.Date;
import java.util.List;

public class RentingOrder {

	String readerName;
	String phone;
	String address;
	String note;
	Date borrowedDate;
	Date returnDate;
	List<Integer> listRentingBook;
	
	public Date getBorrowedDate() {
		return borrowedDate;
	}
	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public List<Integer> getListRentingBook() {
		return listRentingBook;
	}
	public void setListRentingBook(List<Integer> listRentingBook) {
		this.listRentingBook = listRentingBook;
	}	
}
