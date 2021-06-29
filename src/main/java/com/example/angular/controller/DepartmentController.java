package com.example.angular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular.model.Department;
import com.example.angular.response.DepartmentResponse;
import com.example.angular.service.DepartmentService;

@RestController
@RequestMapping("/angularservice/v1")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/departments")
	public List<Department> getDepartmentList(){
		return departmentService.getDepartments();
	}
	
	@PostMapping("/add-department")
	public @ResponseBody ResponseEntity<DepartmentResponse> addDepartment(@RequestBody Department department){
		DepartmentResponse response = new DepartmentResponse("Added successfully");
		departmentService.addDepartment(department);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("/update-department")
	public @ResponseBody ResponseEntity<DepartmentResponse> updateDepartment(@RequestBody Department department){
		DepartmentResponse response = new DepartmentResponse("Updated successfully");
		departmentService.updateDepartment(department.getDepartmentId(), department.getDepartmentName());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-department/{departmentId}")
	public @ResponseBody ResponseEntity<DepartmentResponse> deleteDepartment(@PathVariable int departmentId){
		departmentService.deleteDepartment(departmentId);
		DepartmentResponse response = new DepartmentResponse("Deleted successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
