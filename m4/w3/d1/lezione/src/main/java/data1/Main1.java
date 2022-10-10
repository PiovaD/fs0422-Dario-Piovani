package data1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Students;

public class Main1 {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("data1");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction t = em.getTransaction();

	public static void main(String[] args) {
		System.out.println("here");

		//insertStudent("Malario", "Tossi", "5,2,6,10");
		
		findStudent(2);

		em.close();
		emf.close();

	}
	
	public static void findStudent(int id) {
		Students s = em.find(Students.class, id);
		
		if(s != null) {
			System.out.println(s);
		}
	}

	public static void insertStudent(String name, String lastName, String votes) {

		t.begin();

		em.persist(new Students(name, lastName, votes));

		t.commit();

	}

}
