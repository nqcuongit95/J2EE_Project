package com.j2ee.project.services;

import java.util.List;

import com.j2ee.project.entities.Sach;

public interface ISachService {
	// region Sach

	public List<Sach> getAllSach();
	
	public Sach getSachById(Integer id);
	
	public Integer createSach(Sach sach);
	
	public Integer updateSach(Sach sach);
	
	public void deleteSach(Integer id);

	// endregion
}
