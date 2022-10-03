package com.emeritus.service;

import java.util.List;

import com.emeritus.modal.Courses;

public interface CoursesService {

	public List<Courses> getCourses();
	
	public Courses getCourse(int courseId);
	
	public void addCourse(Courses courses);
	
	public void deleteCourse(int courseId);
}
