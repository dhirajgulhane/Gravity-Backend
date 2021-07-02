package com.example.angular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TESTIMONIAL")
public class Testimonial implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1590068449489205692L;
	
	@Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "FIRST_NAME")
	private String fname;
	
	@Column(name = "LAST_NAME")
	private String lname;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "FEEDBACK")
	private String msg;
	
	@Column(name = "APPROVED")
	private String approved = "N";
	
	public Testimonial() {
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
