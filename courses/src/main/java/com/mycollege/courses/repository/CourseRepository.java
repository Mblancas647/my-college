package com.mycollege.courses.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mycollege.courses.model.Course;

public interface CourseRepository extends MongoRepository<Course, String>{
}
