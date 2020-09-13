package com.talissonmelo.microservicecoursemanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.talissonmelo.microservicecoursemanagement.model.Course;
import com.talissonmelo.microservicecoursemanagement.model.Transaction;
import com.talissonmelo.microservicecoursemanagement.repository.CourseRepository;
import com.talissonmelo.microservicecoursemanagement.repository.TransactionRepository;
import com.talissonmelo.microservicecoursemanagement.service.CourseService;

@Component
public class CouseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	@Override
	public Course findByCourseId(Long id ) {
		return courseRepository.findById(id).orElse(null);
	}
	
	@Override
	public List<Transaction> findTransactionsOfUser(Long userId){
		return transactionRepository.findAllByUserId(userId);
	}
	
	@Override
	public List<Transaction> findTransactionsOfCourse(Long courseId){
		return transactionRepository.findAllByCourseId(courseId);
	}

	@Override
	public Transaction saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
}
