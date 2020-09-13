package com.talissonmelo.microservicecoursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.talissonmelo.microservicecoursemanagement.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
