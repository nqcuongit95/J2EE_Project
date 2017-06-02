package com.j2ee.project.services.implement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import com.j2ee.project.entities.Chitietthongtinmuonsach;
import com.j2ee.project.entities.Sach;
import com.j2ee.project.entities.Thongtinmuonsach;
import com.j2ee.project.entities.renting.NotifyData;
import com.j2ee.project.entities.renting.RentingData;
import com.j2ee.project.services.BookRentingService;

@Transactional
public class BookRentingServiceImpl implements BookRentingService {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Thongtinmuonsach> getAllRenting(Integer offset, Integer maxResults) {
		 return sessionFactory.openSession()
	                .createCriteria(Thongtinmuonsach.class)
	                .setFirstResult(offset!=null?offset:0)
	                .setMaxResults(maxResults!=null?maxResults:10)
	                .list();
	}
	
	 @SuppressWarnings({ "deprecation" })
	    public Long count() {
	        return (Long)sessionFactory.openSession()
	                .createCriteria(Thongtinmuonsach.class)
	                .setProjection(Projections.rowCount())
	                .uniqueResult();
	    }
	 
	public List<Chitietthongtinmuonsach> getDetailsByInfoID(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select a from Chitietthongtinmuonsach a where a.chiTietThongTinMuonSachId =" + id;
		@SuppressWarnings("unchecked")
		Query<Chitietthongtinmuonsach> query = session.createQuery(sql);
		List<Chitietthongtinmuonsach> list = query.list();
		return list;
	}
	public Thongtinmuonsach getInfoByIdOrPhone(String id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select a from Thongtinmuonsach a where a.id =" + id +"or a.soDienThoai = "+id;
		@SuppressWarnings("unchecked")
		Query<Thongtinmuonsach> query = session.createQuery(sql);
		Thongtinmuonsach info = query.getSingleResult();
		return info;
	}
	public Thongtinmuonsach getInfoByID(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		String sql = "Select a from Thongtinmuonsach a where a.id =" + id;
		@SuppressWarnings("unchecked")
		Query<Thongtinmuonsach> query = session.createQuery(sql);
		Thongtinmuonsach info = query.getSingleResult();
		return info;
	}

	public List<RentingData> getBookBorrowed(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<RentingData> result = new ArrayList<RentingData>();
		List<Chitietthongtinmuonsach> details = getDetailsByInfoID(id);
		for (Chitietthongtinmuonsach obj : details) {
			RentingData temp = new RentingData();
			String sql = "Select a from Sach a where a.id =" + obj.getSachId();
			@SuppressWarnings("unchecked")
			Query<Sach> query = session.createQuery(sql);
			Sach info = query.getSingleResult();

			temp.setId(obj.getId());
			temp.setChiTietThongTinMuonSachId(id);
			temp.setGiaMuon(info.getGiaMuon());
			temp.setImageUrl(info.getImageUrl());
			temp.setIsbn(info.getIsbn());
			temp.setMaSach(info.getMaSach());
			temp.setNgayMuon(obj.getNgayMuon());
			temp.setNgayTra(obj.getNgayTra());
			temp.setTacGia(info.getTacGia());
			temp.setTen(info.getTen());
			temp.setTheLoai(info.getTheLoai());
			temp.setTomTat(info.getTomTat());

			result.add(temp);
		}
		return result;
	}

	public NotifyData returnBook(int thongTinMuonId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		
		NotifyData result = new NotifyData();
		
		List<Chitietthongtinmuonsach> details = getDetailsByInfoID(thongTinMuonId);
		for (Chitietthongtinmuonsach obj : details) {
			String sql = "Select a from Sach a where a.id =" + obj.getSachId();
			@SuppressWarnings("unchecked")
			Query<Sach> query = session.createQuery(sql);
			Sach info = query.getSingleResult();
			info.setSoBan(info.getSoBan()+1);
			 obj.setNgayTra(new Date());
			 session.saveOrUpdate(info);
			 session.saveOrUpdate(obj);
		}
		
		result.setSuccess("true");
		result.setContent("Successfully return books");
		result.setHeader("Success");
		return result;
	}
}
