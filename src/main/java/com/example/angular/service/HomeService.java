package com.example.angular.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.angular.dao.GravityRepository;
import com.example.angular.model.Testimonial;
import com.example.angular.model.User;
import com.example.angular.util.EmailSender;


@Service
public class HomeService {
	
	private static final String ENROLL_MSG = "Thank you for showing interest in Gravity ! You have been enrolled for a course. One of our representative will contact you for further discussion.";
	private static final String CONTACT_MSG = "Thank you for your message ! One of our representative will contact you for further discussion.";
	private static final String TESTIMONIAL_MSG = "Thank you for submitting review ! Please expect to apper in testimonials section within 24 hrs. "
			+ "\n Note : Submitted reviews go through approval process to ensure contents are not abusive or misleading.";
	
	private static String USER_NAME = "dhirajgulhane397";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "dhi1991dhi"; // GMail password
    
	@Autowired
	private GravityRepository repo;
	
	public List<String> getCourses(){
		return repo.getCourses().stream().sorted().collect(Collectors.toList());
	}
	
	public String enroll(User user) {
		repo.enroll(user);
		EmailSender.sendFromGMail(USER_NAME, PASSWORD, Arrays.asList("dhirajgulhane397@gmail.com","drjgulhane@gmail.com").toArray(new String[0]), user);
		return !user.getCourse().isEmpty() ? ENROLL_MSG : CONTACT_MSG;
	}
	
	public String submitTestimonial(Testimonial testimonial) {
		repo.postTestimonial(testimonial);
		return TESTIMONIAL_MSG;
	}
}
