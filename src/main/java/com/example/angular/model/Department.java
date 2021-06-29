package com.example.angular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1590068449489205692L;

	@Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;
	
	@Column(name = "NAME")
	private String departmentName;
	
	public Department() {
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
