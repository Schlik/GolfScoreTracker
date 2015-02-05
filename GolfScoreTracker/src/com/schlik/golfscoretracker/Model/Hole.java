package com.schlik.golfscoretracker.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.appengine.api.datastore.Key;

@Entity
public class Hole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="HOLE_ID")
	private Key holeId;

	private int holeNumber, blueTeeDistance, whiteTeeDistance, redTeeDistance;
	private int parValue, mensHandicap, womensHandicap;
	private int keyHashValue;
	private String courseColor;
	
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private Course parentCourse;
	
	public int getKeyHashValue() {
		return keyHashValue;
	}



	public void setKeyHashValue(int keyHashValue) {
		this.keyHashValue = keyHashValue;
	}


	

	

	
	public Hole(){
		
		
	    holeNumber = 0;
	    blueTeeDistance = 0;
	    whiteTeeDistance = 0;
	    redTeeDistance = 0;
	    parValue = 0;
	    mensHandicap = 0;
	    womensHandicap = 0;
	    courseColor = "Blank";
	}
	
	

	public Course getParentCourse() {
		return parentCourse;
	}



	public void setParentCourse(Course parentCourse) {
		this.parentCourse = parentCourse;
	}



	public Key getId() {
		return holeId;
	}

	public void setId(Key holeId) {
		this.holeId = holeId;
	}

	public int getHoleNumber() {
		return holeNumber;
	}

	public void setHoleNumber(int holeNumber) {
		this.holeNumber = holeNumber;
	}

	public int getBlueTeeDistance() {
		return blueTeeDistance;
	}

	public void setBlueTeeDistance(int blueTeeDistance) {
		this.blueTeeDistance = blueTeeDistance;
	}

	public int getWhiteTeeDistance() {
		return whiteTeeDistance;
	}

	public void setWhiteTeeDistance(int whiteTeeDistance) {
		this.whiteTeeDistance = whiteTeeDistance;
	}

	public int getRedTeeDistance() {
		return redTeeDistance;
	}

	public void setRedTeeDistance(int redTeeDistance) {
		this.redTeeDistance = redTeeDistance;
	}

	public int getParValue() {
		return parValue;
	}

	public void setParValue(int parValue) {
		this.parValue = parValue;
	}

	public int getMensHandicap() {
		return mensHandicap;
	}

	public void setMensHandicap(int mensHandicap) {
		this.mensHandicap = mensHandicap;
	}

	public int getWomensHandicap() {
		return womensHandicap;
	}

	public void setWomensHandicap(int womensHandicap) {
		this.womensHandicap = womensHandicap;
	}

	public String getCourseColor() {
		return courseColor;
	}

	public void setCourseColor(String courseColor) {
		this.courseColor = courseColor;
	}



	
	


}
