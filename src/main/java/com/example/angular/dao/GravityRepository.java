/**
 * 
 */
package com.example.angular.dao;

import java.util.List;

import com.example.angular.model.Testimonial;
import com.example.angular.model.User;

/**
 * @author dgulhane
 *
 */
public interface GravityRepository{
	List<String> getCourses();
	
	void enroll(User user);
	
	void postTestimonial(Testimonial testimonial);
}
