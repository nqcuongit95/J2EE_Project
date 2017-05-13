package com.j2ee.project.controllers;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.j2ee.project.entities.Department;
import com.j2ee.project.services.DepartmentService;
 

@Controller
public class HomeController {
 
 @Autowired
 private DepartmentService departmentDAO;
 
 @RequestMapping({ "/", "/home", "/index" })
 public String home(Model model) {
     return "homePage";
 }
 
 @Transactional
 @RequestMapping({ "/deptList" })
 public String deptList(Model model) {
     departmentDAO.createDepartment("Dept Name", "Dept Location");
 
     List<Department> list = departmentDAO.listDepartment();
     for (Department dept : list) {
         System.out.println("Dept No " + dept.getDeptNo());
     }
     model.addAttribute("departments", list);
     return "deptList";
 }
}
