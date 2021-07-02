/**
 * 
 */
package com.example.angular.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.angular.model.Testimonial;
import com.example.angular.model.User;

/**
 * @author dgulhane
 *
 */
@Repository
public class GravityRepositoryImpl implements GravityRepository {
	
	@Autowired
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCourses() {
		return entityManager.createQuery("select courseName from Course").getResultList();
	}
	
	@Transactional
	@Override
	public void enroll(User user) {
		entityManager.persist(user);
	}

	@Transactional
	@Override
	public void postTestimonial(Testimonial testimonial) {
		entityManager.persist(testimonial);
	}

}
