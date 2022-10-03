package com.emeritus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emeritus.modal.Courses;
import com.emeritus.serviceimpl.CoursesServiceImpl;

@RestController
public class CoursesController {
	
	@Autowired
	private CoursesServiceImpl coursesServiceImpl;

	@GetMapping("/getCourses")
	public List<Courses> getCourses(){
		return coursesServiceImpl.getCourses();
	}
	
	@GetMapping("/getCourse/{courseId}")
	public Courses getCourse(@PathVariable int courseId) {
		return coursesServiceImpl.getCourse(courseId);
	}
	
	@PostMapping("/addCourse")
	public void addCourse(@RequestBody Courses courses) {
		coursesServiceImpl.addCourse(courses);
	}
	
	@DeleteMapping("/deleteCourse/{courseId}")
	public void deleteCourse(@PathVariable int courseId) {
		coursesServiceImpl.deleteCourse(courseId);
	}
}
