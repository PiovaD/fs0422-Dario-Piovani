
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.Address;
import models.Person;

public class Main2 {

	public static final String pu = "lezionew3d3";

	public static void main(String[] args) {
		
		//makePerson("Via Epic", "Roma", "Lancillotto");
		//makePerson("Via Garibaldi", "Milano", "Dante");
		//makePerson("Via Roma", "Lecco", "Virgilio");
		
		printAllPeople();
		
		//printAllPeople2();
				
		//findPersonByName("Virgilio");
		
		//findPersonByAddresName("Via Roma");
		
		deletePersonById(4); 
		
		printAllPeople();

	}

	public static void makePerson(String addressName, String addressCity, String personName) {		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		Address a = new Address(addressName, addressCity);
		Person p = new Person(personName, a );
		
		em.persist(p);
		
		t.commit();
		
		em.close();
		emf.close();		
	}
	
	public static void printAllPeople() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery(
				"SELECT p FROM Person p", Person.class
				);
		
		List<Person> r = q.getResultList();
		
		for(Person p:r) {
			System.out.println(p);
		}
				
		em.close();
		emf.close();
	}
	
	public static void printAllPeople2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery(
				"SELECT p.name, a.name as address_name, a.city FROM Person p JOIN p.address a"
				);
		
		List<Object[]> r = q.getResultList();
		
	for(int i = 0; i< r.size(); i++) {
		Object[] o= r.get(i);
		
		System.out.println(Arrays.toString(o));
		
	}
				
		em.close();
		emf.close();
	}
	
	public static void findPersonByName(String n) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createNamedQuery("byName");
		
		q.setParameter("n", n);
		
		List<Person> r = q.getResultList();
		
		for(Person p : r) {
			System.out.println(p);
		}
				
		em.close();
		emf.close();
	}
	
	public static void findPersonByAddresName(String n) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createNamedQuery("byAddressName");
		
		q.setParameter("n", n);
		
		List<String> r = q.getResultList();
		
		for(String p : r) {
			System.out.println(p);
		}
				
		em.close();
		emf.close();
	}
	
	public static void updatePersonById(String newName, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		Query q = em.createQuery(
				"UPDATE Person p SET name = :n WHERE p.id = :id"
				);
		
		q.setParameter("n", newName);
		q.setParameter("id", id);
		
		q.executeUpdate();
		
		t.commit();
		
		em.close();
		emf.close();
	}
	
	public static void deletePersonById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		Query q = em.createQuery(
				"DELETE Person p WHERE p.id = :id"
				);
		
		q.setParameter("id", id);
		
		q.executeUpdate();
		
		t.commit();
		
		em.close();
		emf.close();
	}
}
