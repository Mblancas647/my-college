package com.mycollege.courses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycollege.courses.exception.CourseException;
import com.mycollege.courses.model.Course;
import com.mycollege.courses.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public void addCourse(Course course) {
		//NEED TO ADD VALIDATION AND CHECK TO SEE IF COURSE ALREADY EXISTS
		courseRepository.insert(course);
	}
	
	public void deleteCourse(String courseId) throws CourseException {
		String id = courseId.toUpperCase();
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new CourseException("Course "+id+" not found"));
		courseRepository.delete(course);
	}
	
	public void updateCourse(Course course) throws CourseException {
		//NEED TO ADD VALIDATION AND CREATION OF DTO OBJECT
		String id = course.getCourseId().toUpperCase();
		if(courseRepository.existsById(id)) {
			courseRepository.save(course);
		} else {
			throw new CourseException("Course "+id+" not found");
		}
	}
}
