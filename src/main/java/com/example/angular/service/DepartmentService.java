package com.example.angular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular.dao.DepartmentDao;
import com.example.angular.model.Department;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	public List<Department> getDepartments(){
		return departmentDao.findAll();
	}
	
	public void addDepartment(Department department) {
        this.departmentDao.save(department);
    }
	
	public void updateDepartment(int deptId, String deptName) {
        this.departmentDao.updateDepartment(deptId,deptName);
    }
	
	public void deleteDepartment(int deptId) {
        this.departmentDao.deleteDepartment(deptId);
    }
}
