package lezw3d2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import models.Address;
import models.Person5;
import models.Post;
import models.Vote;

public class Main2 {
	
		public static void main(String[] args) {
			
			//insertPerson5("fabio");
			
			findAddressInfo(1);
			
			findPersonVotes(1);
			
			findVotePerson(3);
			
			//insertVote(10);
			
			printPersonPosts(1);
			
			printPostPeople(1);

		}

		public static void insertPerson5(String name) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			Address a = new Address("via ciao 10", "Milano");
			
			Person5 p = new Person5(name, a);
			
			em.persist(p);
			et.commit();
			
			em.close();
			emf.close();
		}
		
		public static void insertVote(int v) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
			EntityManager em = emf.createEntityManager();
			
			EntityTransaction et = em.getTransaction();
			
			et.begin();
			
			Person5 p = em.find(Person5.class, 1);
			Vote v1 = new Vote(v, p);
			
			em.persist(v1);
			et.commit();
			
			em.close();
			emf.close();
		}
		
		public static void findPersonInfo(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
			EntityManager em = emf.createEntityManager();
			
			Person5 p = em.find(Person5.class, id);
			if(p != null) {
				System.err.println(p.getAddress().getCity());
			}
			
			em.close();
			emf.close();
		}
		
		public static void findAddressInfo(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
			EntityManager em = emf.createEntityManager();
			
			Address a = em.find(Address.class, id);
			if(a != null) {
				System.err.println(a.getPerson().getName());
			}
			
			em.close();
			emf.close();
		}
		
		public static void findPersonVotes(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
			EntityManager em = emf.createEntityManager();
			
			Person5 p = em.find(Person5.class, id);
			if(p != null) {
				
				System.err.println(p.getVotes());
				
				for(Vote vote : p.getVotes()) {
					System.err.println("Voto di: " + p.getName() + ": " + vote);
				}
				
			}
			
			em.close();
			emf.close();
		}
		
		public static void findVotePerson(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
			EntityManager em = emf.createEntityManager();
			
			Vote v = em.find(Vote.class, id);
			if(v != null) {
				
				System.err.println( v.getPerson().getName() );
				
			}
			
			em.close();
			emf.close();
		}
		
		public static void printPersonPosts(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
			EntityManager em = emf.createEntityManager();
			
			Person5 p = em.find(Person5.class, id);
			if(p != null) {
				
				System.err.println("Post di: " + p.getName() );
				
				for(Post post : p.getPosts()) {
					
					System.err.println(post.getText());
				}
			}
			

			
			em.close();
			emf.close();
		}
		
		public static void printPostPeople(int id) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("lezionew3d2");
			EntityManager em = emf.createEntityManager();
			
			Post p = em.find(Post.class, id);
			if(p != null) {
				
				System.err.println("Autori di: " + p.getText());
				
				for(Person5 person : p.getPeople()) {
					
					System.err.println(person.getName());
				}
			}
			

			
			em.close();
			emf.close();
		}
	}

