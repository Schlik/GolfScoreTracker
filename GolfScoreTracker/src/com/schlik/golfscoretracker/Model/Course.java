package com.schlik.golfscoretracker.Model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;






import com.google.appengine.api.datastore.PhoneNumber;



@Entity
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="course_name")
	private String mCourseName;
	
	private PhoneNumber mPhoneNumber;
	
	@OneToMany(mappedBy="mCourse")
	private Map<Integer, Hole> mHoles;
	
	public Course( String name ) {
		mCourseName = name;
		mHoles = new HashMap<Integer, Hole>();
	}

	public String getmCourseName() {
		return mCourseName;
	}

	public void setmCourseName(String mCourseName) {
		this.mCourseName = mCourseName;
	}

	public PhoneNumber getmPhoneNumber() {
		return mPhoneNumber;
	}

	public void setmPhoneNumber(PhoneNumber mPhoneNumber) {
		this.mPhoneNumber = mPhoneNumber;
	}

	public Map<Integer,Hole> getmHoles() {
		return mHoles;
	}

	public void setmHoles(Map<Integer,Hole> mHoles) {
		this.mHoles = mHoles;
	}

	public void setHole(Hole inputHole) {
		mHoles.put(inputHole.getId(), inputHole );
	}




}
