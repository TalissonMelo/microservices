package com.talissonmelo.microservicecoursemanagement.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.DiscoveryClient;
import com.talissonmelo.microservicecoursemanagement.intercomm.UserClient;
import com.talissonmelo.microservicecoursemanagement.model.Transaction;
import com.talissonmelo.microservicecoursemanagement.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private UserClient userClient;

	@Autowired
	private CourseService courseService;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private Environment env;

	@Value("${spring.application.name}")
	private String serviceId;

	@GetMapping("/service/port")
	public String getPort() {
		return "Serviço na porta número: " + env.getProperty("local.server.port");
	}

	@GetMapping("/service/user/{userId}")
	public ResponseEntity<?> findTransactionsOfUser(@PathVariable Long userId) {
		return ResponseEntity.ok(courseService.findTransactionsOfUser(userId));
	}

	@GetMapping("/service/instances")
	public ResponseEntity<?> getInstances() {
		return ResponseEntity.ok(discoveryClient.getInstancesById(serviceId));
	}

	@GetMapping("/course/all")
	public ResponseEntity<?> findAllCourses() {
		return ResponseEntity.ok(courseService.findAll());
	}

	@PostMapping("/course/enroll")
	public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction) {
		transaction.setDateOfIssue(LocalDateTime.now());
		transaction.setCourse(courseService.findByCourseId(transaction.getCourse().getId()));
		return new ResponseEntity<>(courseService.saveTransaction(transaction), HttpStatus.CREATED);
	}

	@GetMapping("/service/course/{courseId}")
	public ResponseEntity<?> findStudentsOfCourse(@PathVariable Long courseId) {
		List<Transaction> transactions = courseService.findTransactionsOfCourse(courseId);
		if (CollectionUtils.isEmpty(transactions)) {
			return ResponseEntity.notFound().build();
		}
		List<Long> ids = transactions.parallelStream().map(t -> t.getUserId()).collect(Collectors.toList());
		List<String> students = userClient.getUsername(ids);
		return ResponseEntity.ok(students);
	}
}