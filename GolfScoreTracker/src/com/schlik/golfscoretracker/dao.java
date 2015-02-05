package com.schlik.golfscoretracker;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.schlik.golfscoretracker.Model.Course;
import com.schlik.golfscoretracker.Model.Hole;

public enum dao {
	INSTANCE;
	

	public List<Hole> listHoles( String inputName) {
		
		List<Hole> returnList = new ArrayList<>();
		
		EntityManager em = EMFService.get().createEntityManager();
		
		String course_name = new String( "Ramblewood Country Club" );
		
		Long hash_value = new Long(course_name.hashCode());
		
		Course ramblewood = em.find( Course.class, KeyFactory.createKey( Course.class.getSimpleName(), course_name ) );
		
		if( ramblewood != null )
			returnList =  ramblewood.getHoles();
		
		
		return returnList;
	}
	
	public Hole getHole( String courseName, int holeNum) {
		
		Hole returnValue = null;
		EntityManager em = EMFService.get().createEntityManager();
		Course course = em.find( Course.class, KeyFactory.createKey( Course.class.getSimpleName(), courseName ) );
		if( course != null ){
			returnValue = course.getHole( holeNum );
		}
		
		return returnValue;
		
	}



	public void update(Hole newHole) {
		EntityManager em = EMFService.get().createEntityManager();
		
		
		
		
		String course_name = new String( "Ramblewood Country Club" );
		
		//Long hash_value = new Long(course_name.hashCode());
		
		Course ramblewood = em.find( Course.class, KeyFactory.createKey( Course.class.getSimpleName(), course_name ) );
		
		if( ramblewood == null ){
			ramblewood = new Course();
			ramblewood.setCourseName("Ramblewood Country Club");
			ramblewood.setCourseId( KeyFactory.createKey( Course.class.getSimpleName(), course_name ));
		
		}
		
		newHole.setParentCourse( ramblewood );
		ramblewood.addHole(newHole);
		
		em.getTransaction().begin();
		
		em.persist( newHole    );
		em.persist( ramblewood );
			
		em.getTransaction().commit();
		em.close();  
		
	}

}
//
//	public List<PubModel> getPubs(String userId) {
//		EntityManager em = EMFService.get().createEntityManager();
//		Query q = em
//				.createQuery("select t from PubModel t where t.author = :userId");
//		q.setParameter("userId", userId);
//		List<PubModel> pubs = q.getResultList();
//		return pubs;
//	}
//
//	public void remove(String name) {
//		EntityManager em = EMFService.get().createEntityManager();
//		try {
//			PubModel pub = em.find(PubModel.class, name);
//			em.remove(pub);
//		} finally {
//			em.close();
//		}
//	}
 
