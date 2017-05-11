package com.j2ee.project.services;

import java.util.List;

import com.j2ee.project.entities.Department;

public interface DepartmentService {
	public List<Department> listDepartment() ;
	  
	  public Integer getMaxDeptId();
	  
	  public void createDepartment(String name,String location);  
}
