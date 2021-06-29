package com.example.angular.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular.dao.HomeDao;
import com.example.angular.model.User;


@Service
public class HomeService {
	
	@Autowired
	private HomeDao homeDao;
	
	public List<String> getCourses(){
		return homeDao.getCourses().stream().sorted().collect(Collectors.toList());
	}
	
	public String enroll(User user) {
		homeDao.save(user);
		return "Enrolled Successfully";
	}
}
