package lezw3d2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Person;
import models.Person2;
import models.Person3;
import models.Person4;

public class Main {
	
	public static void main(String[] args) {
		
//		insertPerson("Paolo");
//		insertPerson("Francesca");
//		insertPerson("Luigi");
//		
//		insertPerson2("Paolo");
//		insertPerson2("Francesca");
//		insertPerson2("Luigi");
//		
//		insertPerson3("Paolo");
//		insertPerson3("Francesca");
//		insertPerson3("Luigi");	
//		
		insertPerson4("Paolo");
		insertPerson4("Francesca");
		insertPerson4("Luigi");
		
		
	}

	public static void insertPerson(String name) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Person p = new Person(name);
		
		em.persist(p);
		
		et.commit();
		
		em.close();
		emf.close();
	}
	
	public static void insertPerson2(String name) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Person2 p = new Person2(name);
		
		em.persist(p);
		
		et.commit();
		
		em.close();
		emf.close();
	}
	
	public static void insertPerson3(String name) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Person3 p = new Person3(name);
		
		em.persist(p);
		
		et.commit();
		
		em.close();
		emf.close();
	}
	
	public static void insertPerson4(String name) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		Person4 p = new Person4(name);
		
		em.persist(p);
		
		et.commit();
		
		em.close();
		emf.close();
	}
}
