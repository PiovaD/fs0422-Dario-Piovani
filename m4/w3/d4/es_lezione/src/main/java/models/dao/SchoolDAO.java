package models.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import models.Gender;
import models.Presence;
import models.Student;
import models.Vote;

public class SchoolDAO {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("es_lezionew3d4");
	private static EntityManager em = emf.createEntityManager();
	
	public static void closeEntity() {
		emf.close();
		em.close();
	}
	
public static void makeIstance() {
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		Student s1 = new Student("s1", Gender.M);		
		Vote v1 = new Vote(s1, 6);
		Vote v2 = new Vote(s1, 8);		
		Set<Vote> votesS1 = new HashSet<Vote>();
		votesS1.add(v1);
		votesS1.add(v2);		
		s1.setVote(votesS1);
		Presence p1 = new Presence(20, s1);
		s1.setPresenza(p1);
		
		Student s2 = new Student("s2", Gender.F);
		Vote v3 = new Vote(s1, 8);
		Vote v4 = new Vote(s2, 7);
		Set<Vote> votesS2 = new HashSet<Vote>();
		votesS1.add(v3);
		votesS1.add(v4);		
		s2.setVote(votesS2);
		Presence p2 = new Presence(22, s2);
		s2.setPresenza(p2);

		
		Student s3 = new Student("s3", Gender.O);
		Vote v5 = new Vote(s3, 7);
		Vote v6 = new Vote(s3, 4);
		Set<Vote> votesS3 = new HashSet<Vote>();
		votesS1.add(v5);	
		votesS1.add(v6);
		s3.setVote(votesS3);
		Presence p3 = new Presence(18, s3);
		s3.setPresenza(p3);
		
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		
		t.commit();	
		
		closeEntity();
	}

}
