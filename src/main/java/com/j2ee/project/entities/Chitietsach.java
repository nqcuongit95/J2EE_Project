package com.j2ee.project.entities;
// Generated May 13, 2017 8:58:41 PM by Hibernate Tools 5.2.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Chitietsach generated by hbm2java
 */
@Entity
@Table(name = "chitietsach", catalog = "bookstore_renting")
public class Chitietsach implements java.io.Serializable {

	private Integer id;
	private Integer maSach;
	private String tenThuocTinh;
	private String giaTri;

	public Chitietsach() {
	}

	public Chitietsach(Integer maSach, String tenThuocTinh, String giaTri) {
		this.maSach = maSach;
		this.tenThuocTinh = tenThuocTinh;
		this.giaTri = giaTri;
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

	@Column(name = "MaSach")
	public Integer getMaSach() {
		return this.maSach;
	}

	public void setMaSach(Integer maSach) {
		this.maSach = maSach;
	}

	@Column(name = "TenThuocTinh", length = 100)
	public String getTenThuocTinh() {
		return this.tenThuocTinh;
	}

	public void setTenThuocTinh(String tenThuocTinh) {
		this.tenThuocTinh = tenThuocTinh;
	}

	@Column(name = "GiaTri", length = 500)
	public String getGiaTri() {
		return this.giaTri;
	}

	public void setGiaTri(String giaTri) {
		this.giaTri = giaTri;
	}

}
