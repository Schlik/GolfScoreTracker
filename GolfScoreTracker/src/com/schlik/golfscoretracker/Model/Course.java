package com.schlik.golfscoretracker.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PhoneNumber;



@Entity
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key courseId;
	
	
	@Column(name="COURSE_NAME")
	private String courseName;
	
	@OneToMany(mappedBy="parentCourse")
	private List<Hole> holes = new ArrayList<>();
	
	
	
	public Course( ) {

	}



	public Key getCourseId() {
		return courseId;
	}



	public void setCourseId(Key courseId) {
		this.courseId = courseId;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public List<Hole> getHoles() {
		return holes;
	}



	public void setHoles(List<Hole> holes) {
		this.holes = holes;
	}





}
