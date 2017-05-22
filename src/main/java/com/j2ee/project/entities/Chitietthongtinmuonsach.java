package com.j2ee.project.entities;
// Generated May 22, 2017 11:53:47 AM by Hibernate Tools 5.2.3.Final

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
 * Chitietthongtinmuonsach generated by hbm2java
 */
@Entity
@Table(name = "chitietthongtinmuonsach", catalog = "bookstore_renting")
public class Chitietthongtinmuonsach implements java.io.Serializable {

	private Integer id;
	private Integer chiTietThongTinMuonSachId;
	private String sachId;
	private String ngayMuon;
	private Date ngayTra;
	private String ghiChu;

	public Chitietthongtinmuonsach() {
	}

	public Chitietthongtinmuonsach(Integer chiTietThongTinMuonSachId, String sachId, String ngayMuon, Date ngayTra,
			String ghiChu) {
		this.chiTietThongTinMuonSachId = chiTietThongTinMuonSachId;
		this.sachId = sachId;
		this.ngayMuon = ngayMuon;
		this.ngayTra = ngayTra;
		this.ghiChu = ghiChu;
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

	@Column(name = "ChiTietThongTinMuonSachID")
	public Integer getChiTietThongTinMuonSachId() {
		return this.chiTietThongTinMuonSachId;
	}

	public void setChiTietThongTinMuonSachId(Integer chiTietThongTinMuonSachId) {
		this.chiTietThongTinMuonSachId = chiTietThongTinMuonSachId;
	}

	@Column(name = "SachID", length = 500)
	public String getSachId() {
		return this.sachId;
	}

	public void setSachId(String sachId) {
		this.sachId = sachId;
	}

	@Column(name = "NgayMuon", length = 20)
	public String getNgayMuon() {
		return this.ngayMuon;
	}

	public void setNgayMuon(String ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NgayTra", length = 19)
	public Date getNgayTra() {
		return this.ngayTra;
	}

	public void setNgayTra(Date ngayTra) {
		this.ngayTra = ngayTra;
	}

	@Column(name = "GhiChu", length = 2000)
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

}
