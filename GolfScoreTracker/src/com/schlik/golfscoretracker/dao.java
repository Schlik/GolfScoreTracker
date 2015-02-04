package com.schlik.golfscoretracker;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.schlik.golfscoretracker.Model.Course;
import com.schlik.golfscoretracker.Model.Hole;

public enum dao {
	INSTANCE;
	
	/** A simple endpoint method that takes a name and says Hi back */
	public List<Hole> listHoles( String inputName) {
		EntityManager em = EMFService.get().createEntityManager();
		Query q = em.createQuery("select m from Course m where m.mCourseName = :courseName");
		q.setParameter("courseName", "Ramblewood Country Club");
		List<Hole> holes = q.getResultList();
		return holes;
	}

	public void add( Hole name) {
		synchronized (this) {
			EntityManager em = EMFService.get().createEntityManager();
			Hole newHole = new Hole( );			
			em.persist(newHole);
			em.close();
		}
	}

	public void update(Hole newHole) {
		EntityManager em = EMFService.get().createEntityManager();
		em.getTransaction().begin();
		
		Course ramblewood = em.find( Course.class, "Ramblewood Country Club");
		
		if( ramblewood == null ){
			ramblewood = new Course("Ramblewood Country Club");
		}
		
		
		
		newHole.setmCourse(ramblewood);
		ramblewood.setHole( newHole );
		
		em.persist( ramblewood );
		em.persist(newHole);
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
 
