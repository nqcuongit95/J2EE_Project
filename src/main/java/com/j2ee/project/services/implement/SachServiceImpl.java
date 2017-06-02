package com.j2ee.project.services.implement;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.j2ee.project.entities.Sach;
import com.j2ee.project.services.ISachService;

@Transactional
public class SachServiceImpl implements ISachService {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// region Sach
	@SuppressWarnings("unchecked")
	public List<Sach> getAllSach() {
		Session session = this.sessionFactory.getCurrentSession();

		List<Sach> result = session.createCriteria(Sach.class).list();

		return result;
	}

	public Sach getSachById(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Sach.class);

		Sach result = (Sach) criteria.add(Restrictions.eq("id", id)).uniqueResult();

		return result;
	}

	public Integer createSach(Sach sach) {
		Session session = this.sessionFactory.getCurrentSession();

		session.persist(sach);

		return sach.getId();
	}

	public Integer updateSach(Sach sach) {
		Session session = this.sessionFactory.getCurrentSession();

		Sach oldSach = this.getSachById(sach.getId());

		sach.setNgayTao(oldSach.getNgayTao());

		session.merge(sach);

		return sach.getId();
	}

	public void deleteSach(Integer id) {
		Session session = this.sessionFactory.getCurrentSession();

		Sach sach = this.getSachById(id);

		if (sach != null) {
			session.delete(sach);
		}
	}

	// endregion
}
