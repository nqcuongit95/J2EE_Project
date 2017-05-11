package com.j2ee.project.services.implement;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.j2ee.project.entities.Department;
import com.j2ee.project.services.DepartmentService;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	private SessionFactory sessionFactory;
	 
	  public void setSessionFactory(SessionFactory sessionFactory) {
	      this.sessionFactory = sessionFactory;
	  }
	 
	  @SuppressWarnings("unchecked")
	  public List<Department> listDepartment() {
	      Session session = this.sessionFactory.getCurrentSession();
	 
	      List<Department> list = session.createQuery("from Department").list();
	 
	      return list;
	  }
	 
	  public Integer getMaxDeptId() {
	      Session session = this.sessionFactory.getCurrentSession();
	      String sql = "Select max(d.deptId) from Department d ";
	      Query query = session.createQuery(sql);
	      Integer maxDeptId = (Integer) query.uniqueResult();
	      if (maxDeptId == null) {
	          return 0;
	      }
	      return maxDeptId;
	  }
	 
	  public void createDepartment(String name, String location) {
	      Integer deptId = getMaxDeptId() + 1;
	      Department dept = new Department();
	      dept.setDeptId(deptId);
	      dept.setDeptNo("D" + deptId);
	      dept.setDeptName(name);
	      dept.setLocation(location);
	      Session session = this.sessionFactory.getCurrentSession();
	      session.persist(dept);
	  }
}
