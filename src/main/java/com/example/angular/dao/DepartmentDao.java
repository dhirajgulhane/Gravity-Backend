/**
 * 
 */
package com.example.angular.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.angular.model.Department;

/**
 * @author dgulhane
 *
 */
@Repository
public interface DepartmentDao extends JpaRepository<Department, Long> {
	
	@Transactional
	@Modifying
	@Query("Update Department d SET d.departmentName=:name WHERE d.departmentId=:id")
	public void updateDepartment(@Param("id") int id, @Param("name") String name);
	
	@Transactional
	@Modifying
	@Query("Delete from Department d WHERE d.departmentId=:id")
	public void deleteDepartment(@Param("id") int id);
}
