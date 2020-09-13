package com.talissonmelo.microservicecoursemanagement.service;

import java.util.List;

import com.talissonmelo.microservicecoursemanagement.model.Course;
import com.talissonmelo.microservicecoursemanagement.model.Transaction;

public interface CourseService {

	Transaction saveTransaction(Transaction transaction);

	List<Transaction> findTransactionsOfCourse(Long courseId);

	List<Transaction> findTransactionsOfUser(Long userId);

	Course findByCourseId(Long id);

	List<Course> findAll();
}
