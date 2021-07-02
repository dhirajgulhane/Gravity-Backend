package com.example.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.angular.model.Testimonial;
import com.example.angular.model.User;
import com.example.angular.response.SuccessResponse;
import com.example.angular.service.HomeService;

@RestController
@RequestMapping("/angularservice/v1")
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/courses")
	public @ResponseBody ResponseEntity<?> getCourses(){
		return ResponseEntity.ok(homeService.getCourses());
	}
	
	@PostMapping("/enroll")
	public @ResponseBody ResponseEntity<SuccessResponse> enroll(@RequestBody User user){
		SuccessResponse response = new SuccessResponse(homeService.enroll(user));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/testimonial")
	public @ResponseBody ResponseEntity<SuccessResponse> submitTestimonial(@RequestBody Testimonial testimonial){
		SuccessResponse response = new SuccessResponse(homeService.submitTestimonial(testimonial));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
