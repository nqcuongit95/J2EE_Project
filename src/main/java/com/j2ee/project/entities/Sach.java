package com.j2ee.project.entities;
// Generated May 21, 2017 7:57:14 PM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Sach generated by hbm2java
 */
@Entity
@Table(name = "sach", catalog = "bookstore_renting")
public class Sach implements java.io.Serializable {

	private Integer id;
	private String maSach;
	private String ten;
	private String tacGia;
	private String tomTat;
	private Integer soBan;
	private String isbn;
	private Date ngayTao;
	private BigDecimal giaMuon;
	private String ghiChu;
	private String imageUrl;

	public Sach() {
	}

	public Sach(String maSach, String ten, String tacGia, String tomTat, Integer soBan, String isbn, Date ngayTao,
			BigDecimal giaMuon, String ghiChu, String imageUrl) {
		this.maSach = maSach;
		this.ten = ten;
		this.tacGia = tacGia;
		this.tomTat = tomTat;
		this.soBan = soBan;
		this.isbn = isbn;
		this.ngayTao = ngayTao;
		this.giaMuon = giaMuon;
		this.ghiChu = ghiChu;
		this.imageUrl = imageUrl;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "MaSach", length = 12)
	public String getMaSach() {
		return this.maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	@Column(name = "Ten", length = 500)
	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	@Column(name = "TacGia", length = 2000)
	public String getTacGia() {
		return this.tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	@Column(name = "TomTat", length = 1000)
	public String getTomTat() {
		return this.tomTat;
	}

	public void setTomTat(String tomTat) {
		this.tomTat = tomTat;
	}

	@Column(name = "SoBan")
	public Integer getSoBan() {
		return this.soBan;
	}

	public void setSoBan(Integer soBan) {
		this.soBan = soBan;
	}

	@Column(name = "ISBN", length = 2000)
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NgayTao", length = 19)
	public Date getNgayTao() {
		return this.ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	@Column(name = "GiaMuon", scale = 4)
	public BigDecimal getGiaMuon() {
		return this.giaMuon;
	}

	public void setGiaMuon(BigDecimal giaMuon) {
		this.giaMuon = giaMuon;
	}

	@Column(name = "GhiChu", length = 2000)
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Column(name = "ImageUrl", length = 1000)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
