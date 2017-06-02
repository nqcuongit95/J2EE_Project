package com.j2ee.project.services;

import java.util.List;

import com.j2ee.project.entities.rentingorder.RentingOrder;
import com.j2ee.project.entities.search.ApiResult;
import com.j2ee.project.entities.search.BookData;;

public interface RentingService {
	
	ApiResult<BookData> GetListRenting(List<Integer> listRenting);
	ApiResult<String> ProcessRenting(RentingOrder order);
}
