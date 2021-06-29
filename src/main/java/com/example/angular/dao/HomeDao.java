/**
 * 
 */
package com.example.angular.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.angular.model.User;

/**
 * @author dgulhane
 *
 */
@Repository
public interface HomeDao extends JpaRepository<User, Integer> {
	
	@Modifying
	@Query("select courseName from Course")
	public List<String> getCourses();
}
