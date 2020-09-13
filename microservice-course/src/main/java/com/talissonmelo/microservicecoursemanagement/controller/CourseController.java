package com.talissonmelo.microservicecoursemanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.microservicecoursemanagement.intercomm.UserClient;

@RestController
public class CourseController {

	@Autowired
	private UserClient userClient;
	
	
}
