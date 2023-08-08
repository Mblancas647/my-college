package com.mycollege.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycollege.courses.exception.CourseException;
import com.mycollege.courses.model.Course;
import com.mycollege.courses.service.CourseService;


@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping
	public ResponseEntity<String> addUser(@RequestBody Course course) throws CourseException{
		courseService.addCourse(course);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{courseId}")
	public ResponseEntity<String> deleteUser(@PathVariable String courseId) throws CourseException{
		courseService.deleteCourse(courseId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<String> updateUser(@RequestBody Course course) throws CourseException{
		courseService.updateCourse(course);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
