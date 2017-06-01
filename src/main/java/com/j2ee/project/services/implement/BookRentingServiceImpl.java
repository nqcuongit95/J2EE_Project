package com.j2ee.project.services.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.j2ee.project.entities.Chitietthongtinmuonsach;
import com.j2ee.project.entities.Sach;
import com.j2ee.project.entities.Thongtinmuonsach;
import com.j2ee.project.entities.rentingorder.RentingOrder;
import com.j2ee.project.entities.search.ApiResult;
import com.j2ee.project.entities.search.BookData;
import com.j2ee.project.services.BookRentingService;

@Transactional
public class BookRentingServiceImpl implements BookRentingService {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ApiResult<BookData> GetListRenting(List<Integer> listRenting) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		ApiResult<BookData> result = new ApiResult<BookData>();
		List<BookData> listBook = new ArrayList<BookData>();
		
		for (Integer id : listRenting) {
			
			String hql = "from Sach where id = :bookId";
			Query query = session.createQuery(hql);
			query.setParameter("bookId", id);
			List<Sach> book = query.list();
			
			BookData b = new BookData();
			b.setId(book.get(0).getId());
			b.setRentPrice(book.get(0).getGiaMuon());
			b.setTitle(book.get(0).getTen());
			
			listBook.add(b);
		}
		
		result.setSuccess("true");
		result.setResults(listBook);
		
		return result;
	}

	public ApiResult<String> ProcessRenting(RentingOrder order) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		Thongtinmuonsach info = new Thongtinmuonsach();
		info.setTenDocGia(order.getReaderName());
		info.setSoDienThoai(order.getPhone());
		info.setDiaChi(order.getAddress());
		info.setGhiChu(order.getNote());
		info.setNgayTao(new Date());
		
		session.save(info);
		
		for (int bookId : order.getListRentingBook()) {
			Chitietthongtinmuonsach detail = new Chitietthongtinmuonsach();
			detail.setNgayMuon(order.getBorrowedDate());
			detail.setNgayTra(order.getReturnDate());
			detail.setSachId(Integer.toString(bookId));
			detail.setChiTietThongTinMuonSachId(info.getId());
			session.save(detail);
		}
		
		ApiResult<String> result = new ApiResult<String>();
		result.setSuccess("true");
		
		return result;
	}	


	

}
