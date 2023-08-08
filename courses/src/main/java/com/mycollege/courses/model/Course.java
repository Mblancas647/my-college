package com.mycollege.courses.model;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("courses")
public class Course {
	@Id
	private String courseId;
	private String courseName;
	private String courseDescription;
	private int courseUnits;
	private String[] courseRequirements;
	public Course(String courseId, String courseName, String courseDescription, int courseUnits,
			String[] courseRequirements) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseUnits = courseUnits;
		this.courseRequirements = courseRequirements;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public int getCourseUnits() {
		return courseUnits;
	}
	public void setCourseUnits(int courseUnits) {
		this.courseUnits = courseUnits;
	}
	public String[] getCourseRequirements() {
		return courseRequirements;
	}
	public void setCourseRequirements(String[] courseRequirements) {
		this.courseRequirements = courseRequirements;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", courseUnits=" + courseUnits + ", courseRequirements="
				+ Arrays.toString(courseRequirements) + "]";
	}
}
