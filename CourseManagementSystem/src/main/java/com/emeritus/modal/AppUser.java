package com.emeritus.modal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class AppUser {
	
	@Id
	private int userId;
	
	private String userName;
	
	@OneToMany(targetEntity = Courses.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "courseFK", referencedColumnName = "userId")
	private List<Courses> courses;

	public AppUser(int userId, String userName, List<Courses> courses) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.courses = courses;
	}
	
	public AppUser() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
}
