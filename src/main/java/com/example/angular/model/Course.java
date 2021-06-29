package com.example.angular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1590068449489205692L;
	
	@Column(name = "COURSE_ID")
    @Id
	private int courseId;
	
	@Column(name = "COURSE_NAME")
	private String courseName;
	
	public Course() {
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
