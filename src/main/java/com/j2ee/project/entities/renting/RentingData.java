package com.j2ee.project.entities.renting;

import com.j2ee.project.entities.Thongtinmuonsach;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.j2ee.project.entities.Chitietthongtinmuonsach;;

public class RentingData {
	Thongtinmuonsach info;
	List<Chitietthongtinmuonsach> details;
	
	private Integer id;
	private Integer chiTietThongTinMuonSachId;
	private String sachId;
	private String ngayMuon;
	private Date ngayTra;
	private String maSach;
	private String ten;
	private String tacGia;
	private String tomTat;
	private Integer soBan;
	private String isbn;
	private BigDecimal giaMuon;
	private String imageUrl;
	private String theLoai;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChiTietThongTinMuonSachId() {
		return chiTietThongTinMuonSachId;
	}
	public void setChiTietThongTinMuonSachId(Integer chiTietThongTinMuonSachId) {
		this.chiTietThongTinMuonSachId = chiTietThongTinMuonSachId;
	}
	public String getSachId() {
		return sachId;
	}
	public void setSachId(String sachId) {
		this.sachId = sachId;
	}
	public String getNgayMuon() {
		return ngayMuon;
	}
	public void setNgayMuon(String ngayMuon) {
		this.ngayMuon = ngayMuon;
	}
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}
	public String getMaSach() {
		return maSach;
	}
	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTacGia() {
		return tacGia;
	}
	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}
	public String getTomTat() {
		return tomTat;
	}
	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}
	public Integer getSoBan() {
		return soBan;
	}
	public void setSoBan(Integer soBan) {
		this.soBan = soBan;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public BigDecimal getGiaMuon() {
		return giaMuon;
	}
	public void setGiaMuon(BigDecimal giaMuon) {
		this.giaMuon = giaMuon;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	
	public Thongtinmuonsach getInfo() {
		return info;
	}
	public void setInfo(Thongtinmuonsach info) {
		this.info = info;
	}
	public List<Chitietthongtinmuonsach> getDetails() {
		return details;
	}
	public void setDetails(List<Chitietthongtinmuonsach> details) {
		this.details = details;
	}
}
