
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import models.Address;
import models.Person;

public class Main {
	public static final String pu = "lezionew3d4";

	public static void main(String[] args) {

		// criteriaQuery1();
		// criteriaQuery2();
		// criteriaQuery3();
		// criteriaQuery4();
		// criteriaQuery5("Dante", 2);
		//criteriaQuery6("Dante", 2);
		criteriaQuery7("Dante");
	}

	public static void criteriaQuery1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Person> cq = cb.createQuery(Person.class);

		Root<Person> p = cq.from(Person.class);

		Query q = em.createQuery(cq);

		List<Person> r = q.getResultList();

		for (Person person : r) {
			System.out.println(person);
		}

		em.close();
		emf.close();

	}

	public static void criteriaQuery2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Person> cq = cb.createQuery(Person.class);

		Root<Person> p = cq.from(Person.class);

		ParameterExpression<String> param = cb.parameter(String.class);

		cq.select(p)
				.where(cb.equal(p, param));

		Query q = em.createQuery(cq);
		q.setParameter(param, "Dante");

		List<Person> r = q.getResultList();

		for (Person person : r) {
			System.out.println(person);
		}

		em.close();
		emf.close();

	}

	public static void criteriaQuery3() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<String> cq = cb.createQuery(String.class);

		Root<Person> p = cq.from(Person.class);

		ParameterExpression<Integer> param = cb.parameter(Integer.class);

		cq.select(p.get("name"))
				.where(cb.lessThan(p.get("id"), param));

		Query q = em.createQuery(cq);
		q.setParameter(param, 3);

		List<String> r = q.getResultList();

		for (String person : r) {
			System.out.println(person);
		}

		em.close();
		emf.close();

	}

	public static void criteriaQuery4() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Person> p = cq.from(Person.class);

		ParameterExpression<Integer> param = cb.parameter(Integer.class);

		cq.multiselect(p.get("name"), p.get("id"))
				.where(cb.lessThan(p.get("id"), param));

		Query q = em.createQuery(cq);
		q.setParameter(param, 3);

		List<Object[]> r = q.getResultList();

		for (Object[] person : r) {
			System.out.println(person[0] + " " + person[1]);
		}

		em.close();
		emf.close();

	}

	public static void criteriaQuery5(String name, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Person> p = cq.from(Person.class);

		Expression<String> personName = p.get("name");
		Expression<String> personId = p.get("id");

		Predicate pd1 = cb.equal(personName, name);
		Predicate pd2 = cb.equal(personId, id);

		cq.multiselect(p.get("name"), p.get("id"))
				.where(cb.and(pd1, pd2));

		Query q = em.createQuery(cq);

		List<Object[]> r = q.getResultList();

		for (Object[] person : r) {
			System.out.println(person[0] + " " + person[1]);
		}

		em.close();
		emf.close();

	}

	public static void criteriaQuery6(String name, int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Person> p = cq.from(Person.class);

		ParameterExpression<String> param1 = cb.parameter(String.class);
		ParameterExpression<Integer> param2 = cb.parameter(Integer.class);

		Expression<String> personName = p.get("name");
		Expression<String> personId = p.get("id");

		Predicate pd1 = cb.equal(personName, param1);
		Predicate pd2 = cb.equal(personId, param2);

		cq.multiselect(p.get("name"), p.get("id"))
				.where(cb.and(pd1, pd2));

		Query q = em.createQuery(cq);

		q.setParameter(param1, name);
		q.setParameter(param2, id);

		List<Object[]> r = q.getResultList();

		for (Object[] person : r) {
			System.out.println(person[0] + " " + person[1]);
		}

		em.close();
		emf.close();

	}
	
	public static void criteriaQuery7(String name) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(pu);
		EntityManager em = emf.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<Person> p = cq.from(Person.class);

		ParameterExpression<String> param1 = cb.parameter(String.class);

		Expression<String> personName = p.get("name");

		Predicate pd1 = cb.equal(personName, param1);
		
		Join<Person, Address> a = p.join("address", JoinType.LEFT);

		cq.multiselect(p.get("name"), a.get("city"))
				.where(
						pd1
						);

		Query q = em.createQuery(cq);

		q.setParameter(param1, name);

		List<Object[]> r = q.getResultList();

		for (Object[] person : r) {
			System.out.println(person[0] + " " + person[1]);
		}

		em.close();
		emf.close();

	}
}
