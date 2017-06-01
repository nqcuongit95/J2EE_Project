package com.j2ee.project.services;

import com.j2ee.project.entities.search.ApiResult;;

public interface BookRentingService {
	
	ApiResult<String> MarkBookForRenting(int id);
	
}
