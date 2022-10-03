package com.emeritus.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emeritus.modal.Courses;
import com.emeritus.repository.CoursesRepository;
import com.emeritus.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService{

	@Autowired
	private CoursesRepository coursesRepository;
	
	@Override
	public List<Courses> getCourses() {
		return coursesRepository.findAll();
	}

	@Override
	public Courses getCourse(int courseId) {
		return coursesRepository.findById(courseId).get();
	}

	@Override
	public void addCourse(Courses courses) {
		coursesRepository.save(courses);
	}

	@Override
	public void deleteCourse(int courseId) {
		coursesRepository.deleteById(courseId);
	}

}
