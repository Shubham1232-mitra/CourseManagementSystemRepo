package com.emeritus.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Courses {

	@Id
	private int courseId;
	
	private String courseName;
	
	@OneToMany(targetEntity = Assignment.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "assignmentFK", referencedColumnName = "courseId")
	private List<Assignment> listAssignments;

	public Courses() {}

	public Courses(int courseId, String courseName, List<Assignment> listAssignments) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
	this.listAssignments = listAssignments;
}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public List<Assignment> getListAssignments() {
		return listAssignments;
	}

	public void setListAssignments(List<Assignment> listAssignments) {
		this.listAssignments = listAssignments;
	}
}
