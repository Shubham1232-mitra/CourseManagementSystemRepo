package com.emeritus.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.emeritus.modal.AppUser;
import com.emeritus.modal.Assignment;
import com.emeritus.modal.Courses;
import com.emeritus.serviceimpl.AppUserServiceImpl;
import com.emeritus.serviceimpl.CoursesServiceImpl;

@DataJpaTest
class CourseManagementSystemApplicationTests{

	@Autowired
	private AppUserServiceImpl appUserServiceImpl;
	
	@Autowired
	private CoursesServiceImpl coursesServiceImpl;
	
	private Courses getCourses() {
		Assignment assignment = getAssignment();
		List<Assignment> listAssignments = new ArrayList<Assignment>();
		listAssignments.add(assignment);
		Courses courses = new Courses(1, "Java Programming Course", listAssignments);
		return courses;
	}
	
	private Assignment getAssignment() {
		Assignment assignment = new Assignment(1, 1, "Week-1 Assignment");
		return assignment;
	}
	
	@Test
	public void addUserTest() {
		AppUser appUser = new AppUser();
		Courses courses = getCourses();
		appUser.setUserId(1);
		appUser.setUserName("Shubham");
		List<Courses> listCourses = new ArrayList<Courses>();
		listCourses.add(courses);
		appUser.setCourses(listCourses);
		appUserServiceImpl.addUser(appUser);
		assertNotNull(appUser);
	}
	
	@Test
	public void getAllUsersTest() {
		AppUser appUser = new AppUser();
		Courses courses = getCourses();
		appUser.setUserId(1);
		appUser.setUserName("Shubham");
		List<Courses> listCourses = new ArrayList<Courses>();
		listCourses.add(courses);
		appUser.setCourses(listCourses);
		
		AppUser appUser2 = new AppUser();
		Courses courses2 = getCourses();
		appUser2.setUserId(2);
		appUser2.setUserName("Swati");
		List<Courses> listCourses2 = new ArrayList<Courses>();
		listCourses2.add(courses2);
		appUser2.setCourses(listCourses2);
		
		appUserServiceImpl.addUser(appUser);
		appUserServiceImpl.addUser(appUser2);
		assertEquals(appUserServiceImpl.getAllUsers().size(), 2);
	}
	
	@Test
	public void getUserTest() {
		AppUser appUser = new AppUser();
		Courses courses = getCourses();
		appUser.setUserId(1);
		appUser.setUserName("Shubham");
		List<Courses> listCourses = new ArrayList<Courses>();
		listCourses.add(courses);
		appUser.setCourses(listCourses);
		
		appUserServiceImpl.addUser(appUser);
		assertEquals(appUserServiceImpl.getUser(1).getUserName(), "Shubham");
	}
	
	@Test
	public void deleteUserTest() {
		AppUser appUser = new AppUser();
		Courses courses = getCourses();
		appUser.setUserId(1);
		appUser.setUserName("Shubham");
		List<Courses> listCourses = new ArrayList<Courses>();
		listCourses.add(courses);
		appUser.setCourses(listCourses);
		
		AppUser appUser2 = new AppUser();
		Courses courses2 = getCourses();
		appUser2.setUserId(2);
		appUser2.setUserName("Swati");
		List<Courses> listCourses2 = new ArrayList<Courses>();
		listCourses2.add(courses2);
		appUser2.setCourses(listCourses2);
		
		appUserServiceImpl.addUser(appUser);
		appUserServiceImpl.addUser(appUser2);
		
		appUserServiceImpl.deleteUser(2);
		assertEquals(appUserServiceImpl.getAllUsers().size(), 1);
	}
	
	@Test
	public void addCourseTest() {
		Courses courses = getCourses();
		coursesServiceImpl.addCourse(courses);
		assertNotNull(courses);
	}
	
	@Test
	public void getCoursesTest() {
		Courses courses = getCourses();
		Courses courses2 = getCourses();
		courses2.setCourseId(2);
		courses2.setCourseName("Machine Learning");
		
		coursesServiceImpl.addCourse(courses);
		coursesServiceImpl.addCourse(courses2);
		
		assertEquals(coursesServiceImpl.getCourses().size(), 2);
	}
	
	@Test
	public void getCourse() {
		Courses courses = getCourses();
		Courses courses2 = getCourses();
		courses2.setCourseId(2);
		courses2.setCourseName("Machine Learning");
		
		coursesServiceImpl.addCourse(courses);
		coursesServiceImpl.addCourse(courses2);
		
		assertEquals(coursesServiceImpl.getCourse(2).getCourseName(), "Machine Learning");
	}
	
	@Test
	public void deleteCourseTest() {
		Courses courses = getCourses();
		Courses courses2 = getCourses();
		courses2.setCourseId(2);
		courses2.setCourseName("Machine Learning");
		
		coursesServiceImpl.addCourse(courses);
		coursesServiceImpl.addCourse(courses2);
		
		coursesServiceImpl.deleteCourse(1);
		assertEquals(coursesServiceImpl.getCourses().size(), 1);
	}
}
