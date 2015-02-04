package com.schlik.golfscoretracker.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;

	private int mHoleNumber, mBlueTeeDistance, mWhiteTeeDistance, mRedTeeDistance;
	private int mParValue, mMensHandicap, mWomensHandicap;
	
	private String mCourseColor;
	
	@ManyToOne()
	@JoinColumn(name="course_name")
	private Course mCourse;
	
	
	public Course getmCourse() {
		return mCourse;
	}
	public void setmCourse(Course mCourse) {
		this.mCourse = mCourse;
	}
	public Hole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getmHoleNumber() {
		return mHoleNumber;
	}
	public void setmHoleNumber(int mHoleNumber) {
		this.mHoleNumber = mHoleNumber;
	}
	public int getmBlueTeeDistance() {
		return mBlueTeeDistance;
	}
	public void setmBlueTeeDistance(int mBlueTeeDistance) {
		this.mBlueTeeDistance = mBlueTeeDistance;
	}
	public int getmWhiteTeeDistance() {
		return mWhiteTeeDistance;
	}
	public void setmWhiteTeeDistance(int mWhiteTeeDistance) {
		this.mWhiteTeeDistance = mWhiteTeeDistance;
	}
	public int getmRedTeeDistance() {
		return mRedTeeDistance;
	}
	public void setmRedTeeDistance(int mRedTeeDistance) {
		this.mRedTeeDistance = mRedTeeDistance;
	}
	public int getmParValue() {
		return mParValue;
	}
	public void setmParValue(int mParValue) {
		this.mParValue = mParValue;
	}
	public int getmMensHandicap() {
		return mMensHandicap;
	}
	public void setmMensHandicap(int mMensHandicap) {
		this.mMensHandicap = mMensHandicap;
	}
	public int getmWomensHandicap() {
		return mWomensHandicap;
	}
	public void setmWomensHandicap(int mWomensHandicap) {
		this.mWomensHandicap = mWomensHandicap;
	}
	public String getmCourseColor() {
		return mCourseColor;
	}
	public void setmCourseColor(String mCourseColor) {
		this.mCourseColor = mCourseColor;
	}
	
	



}
