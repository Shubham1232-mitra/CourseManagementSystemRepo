package com.emeritus.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assignment")
public class Assignment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int assignmentId;
	
	private int weekNumber;
	
	private String assignmentDesc;
	
	@ManyToOne
	private Courses courses;
	
	public Assignment(int assignmentId, int weekNumber, String assignmentDesc) {
		super();
		this.assignmentId = assignmentId;
		this.weekNumber = weekNumber;
		this.assignmentDesc = assignmentDesc;
	}

	public Assignment() {}

	public int getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}

	public int getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(int weekNumber) {
		this.weekNumber = weekNumber;
	}

	public String getAssignmentDesc() {
		return assignmentDesc;
	}

	public void setAssignmentDesc(String assignmentDesc) {
		this.assignmentDesc = assignmentDesc;
	}
}
