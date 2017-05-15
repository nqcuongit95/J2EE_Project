package com.j2ee.project.services;

import java.util.List;

import com.j2ee.project.entities.Sach;

public interface BookSearchingService {
	List<Sach> FindBookByTitle(String title);
}
