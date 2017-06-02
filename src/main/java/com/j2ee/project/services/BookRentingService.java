package com.j2ee.project.services;

import java.util.List;

import com.j2ee.project.entities.Chitietthongtinmuonsach;
import com.j2ee.project.entities.Thongtinmuonsach;
import com.j2ee.project.entities.renting.*;


public interface BookRentingService {
	public List<Thongtinmuonsach> getAllRenting(Integer offset, Integer maxResults);
	public List<Chitietthongtinmuonsach> getDetailsByInfoID(int id);
	public Thongtinmuonsach getInfoByID(int id);
	public List<RentingData> getBookBorrowed(int id);
	public Long count() ;
	public NotifyData returnBook(int thongTinMuonId);
	public Thongtinmuonsach getInfoByIdOrPhone(String id);
} 
