import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import models.s1.S1_Cat;
import models.s1.S1_Dog;
import models.s2.S2_FastCar;
import models.s2.S2_UtilityCar;
import models.s3.S3_C1;
import models.s3.S3_C2;
import models.s3.S3_C3;
import models.s4.S4_C2;
import models.s4.S4_C3;

public class Main {

	public static final String pu = "lezionew3d3";

	public static void main(String[] args) {

//		s1();

//		s2();
		
//		s2Query();
		
//		s3();
		
		s4();

	}

	public static void s1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);

		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();

		t.begin();

		S1_Dog d1 = new S1_Dog("Artu", 3, "Paolo");

		S1_Dog d2 = new S1_Dog("Blu", 3, "Francesca");

		S1_Cat c1 = new S1_Cat("Virgola", 3, 5);

		S1_Cat c2 = new S1_Cat("Cleo", 3, 2);

		em.persist(d1);
		em.persist(d2);
		em.persist(c1);
		em.persist(c2);

		t.commit();

		em.close();
		emf.close();
	}

	public static void s2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);

		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();

		t.begin();

		S2_FastCar f1 = new S2_FastCar("Huayra", "Pagani", 300, 70);

		S2_FastCar f2 = new S2_FastCar("Huracan", "Lamborghini", 310, 70);

		S2_UtilityCar u1 = new S2_UtilityCar("Panda", "Fiat", false, 2);

		S2_UtilityCar u2 = new S2_UtilityCar("Yaris", "Toyota", true, 8);

		em.persist(f1);
		em.persist(f2);
		em.persist(u1);
		em.persist(u2);

		t.commit();

		em.close();
		emf.close();
	}

	public static void s2Query() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);

		EntityManager em = emf.createEntityManager();

		try {
			Query q = em.createNativeQuery(
					"SELECT s2_car.id, name, brand, comfort_lvl, for_family\r\n"
					+ "FROM s2_car JOIN s2_utilitycar ON s2_utilitycar.id = s2_car.id\r\n"
					+ "WHERE s2_car.id = 3");

			List<Object[]> res = q.getResultList();

			for (int i = 0; i < res.size(); i++) {
				Object[] o = res.get(i);
				System.out.println("ID: " + o[0]);
				System.out.println("Name: " + o[1]);
				System.out.println("Brand: " + o[2]);
				System.out.println("Family: " + o[3]);
				System.out.println("Comfort: " + o[4]);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		em.close();
		emf.close();

	}

	public static void s3() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);

		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();

		t.begin();
		
		S3_C1 c1_1 = new S3_C1("Segreteria", "telefonica");

		S3_C2 c2_1 = new S3_C2("Ciao", "luke", "sono");

		S3_C2 c2_2 = new S3_C2("tuo", "padre", "e");

		S3_C3 c3_1 = new S3_C3("sono","stufo", "di");

		S3_C3 c3_2 = new S3_C3("pagare", "gli", "alimenti");

		em.persist(c1_1);
		em.persist(c2_1);
		em.persist(c2_2);
		em.persist(c3_1);
		em.persist(c3_2);

		t.commit();

		em.close();
		emf.close();
	}

	public static void s4() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);

		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();

		t.begin();
		
		S4_C2 c2_1 = new S4_C2("Ciao", "luke", "sono");

		S4_C2 c2_2 = new S4_C2("tuo", "padre", "e");

		S4_C3 c3_1 = new S4_C3("sono","stufo", "di");

		S4_C3 c3_2 = new S4_C3("pagare", "gli", "alimenti");
		
		em.persist(c2_1);
		em.persist(c2_2);
		em.persist(c3_1);
		em.persist(c3_2);

		t.commit();

		em.close();
		emf.close();
	}
}
