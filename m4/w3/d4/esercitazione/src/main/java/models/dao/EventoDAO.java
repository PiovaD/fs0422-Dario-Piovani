package models.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Concerto;
import models.Evento;
import models.GaraDiAtletica;
import models.GenereConcerto;
import models.PartitaDiCalcio;
import models.Persona;
import utils.JpaUtil;
import utils.LogColor;

public class EventoDAO {
	private static final Logger logger = LoggerFactory.getLogger(EventoDAO.class);

	public static void save(Evento obj) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			EntityTransaction t = em.getTransaction();

			t.begin();

			em.persist(obj);

			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.RED("Errore di salvataggio Evento:  " + obj.getClass()
					.getSimpleName()), ex);
		} finally {
			em.close();
		}

	}

	public static Evento getById(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {

			return em.find(Evento.class, id);

		} finally {
			em.close();
		}

	}

	public static void delete(Long id) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {
			EntityTransaction t = em.getTransaction();

			t.begin();

			em.remove(em.find(Evento.class, id));

			t.commit();
		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.RED("Errore cancellazione Evento: " + id), ex);

		} finally {
			em.close();
		}

	}

	public static void refresh(Evento obj) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			em.refresh(obj);

		} catch (Exception ex) {
			em.getTransaction()
					.rollback();

			logger.error(LogColor.RED("Error refreshing Evento: " + obj.getClass()
					.getSimpleName()), ex);

		} finally {
			em.close();
		}

	}

	public static List<Concerto> getConcertiInStreaming(boolean isStreaming) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		try {

			Query q = em.createNamedQuery("getIsStreaming");

			q.setParameter("isSt", isStreaming);

			return q.getResultList();

		} catch (Exception e) {
			logger.error(LogColor.RED(e.getMessage()));
		} finally {
			em.close();
		}

		return null;
	}

	public static List<Concerto> getConcertiPerGenere(GenereConcerto genere) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			Query q = em.createNamedQuery("getConcertGenre");

			q.setParameter("genere", genere);

			return q.getResultList();

		} catch (Exception e) {
			logger.error(LogColor.RED(e.getMessage()));
		} finally {
			em.close();
		}
		return null;
	}

	public static void getPartiteVinteInCasa(String squadra) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object> cq = cb.createQuery(Object.class);

		Root<PartitaDiCalcio> p = cq.from(PartitaDiCalcio.class);

		Expression<String> squadraVincente = p.get("squadraVincente");
		Expression<String> squadraCasa = p.get("squadraCasa");

		Predicate pd1 = cb.equal(squadraVincente, squadra);
		Predicate pd2 = cb.equal(squadraCasa, squadra);

		cq.select(squadraVincente)
				.where(cb.and(pd1, pd2));

		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);

		List<Object> list = q.getResultList();

		System.out.println("La squadra " + squadra + " ha vinto " + list.size() + " partite in casa.");

		em.close();
	}

	public static void getPartiteVinteInTrasferta(String squadra) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object> cq = cb.createQuery(Object.class);

		Root<PartitaDiCalcio> p = cq.from(PartitaDiCalcio.class);

		Expression<String> squadraVincente = p.get("squadraVincente");
		Expression<String> squadraTrasferta = p.get("squadraOspite");

		Predicate pd1 = cb.equal(squadraVincente, squadra);
		Predicate pd2 = cb.equal(squadraTrasferta, squadra);

		cq.select(squadraVincente)
				.where(cb.and(pd1, pd2));

		// prendi tutte le entita' di tipo person
		Query q = em.createQuery(cq);

		List<Object> list = q.getResultList();

		System.out.println("La squadra " + squadra + " ha vinto " + list.size() + " partite in trasferta.");

		em.close();
	}

	public static void getPartitePareggiate(String squadra) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object> cq = cb.createQuery(Object.class);

		Root<PartitaDiCalcio> p = cq.from(PartitaDiCalcio.class);

		Expression<String> squadraCasa = p.get("squadraCasa");
		Expression<String> squadraTrasferta = p.get("squadraOspite");
		Expression<String> squadraVincente = p.get("squadraVincente");

		Predicate pd1 = cb.equal(squadraCasa, squadra);
		Predicate pd2 = cb.equal(squadraTrasferta, squadra);
		Predicate pd3 = cb.equal(squadraVincente, "pareggio");

		// pd1 or pd2 and pd3
		cq.select(p.get("id"))
				.where(cb.and(cb.or(pd1, pd2), pd3));

		Query q = em.createQuery(cq);

		List<Object> list = q.getResultList();

		System.out.println("La squadra " + squadra + " ha pareggiato " + list.size() + " partite.");

		em.close();
	}

	public static void getGareDiAtleticaPerVincitore(Persona vincitore) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

		Root<GaraDiAtletica> p = cq.from(GaraDiAtletica.class);

		cq.select(p.get("id"))
				.where(cb.equal(p.get("winner"), vincitore));

		Query q = em.createQuery(cq);

		List<GaraDiAtletica> list = q.getResultList();

		System.out.println(list.size());

		em.close();
	}

	public static void getGareDiAtleticaPerPartecipante(Persona partecipante) {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {

			Query query = em.createNamedQuery("garePerPartecipante");

			query.setParameter("persona", partecipante);
			List<GaraDiAtletica> list = query.getResultList();

			System.out.println(list.size());

		} finally {
			em.close();
		}
	}

	public static void getEventiSoldOut() {
		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();
		try {
			Query q = em.createNamedQuery("eventiSoldOut");
			List<Evento> list = q.getResultList();

			System.out.println(list.size());
		} finally {
			em.close();
		}
	}

	public static void getEventiPerInvitato(Persona invitato) {
//		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
//		try {
//			Query q = em.createNamedQuery("eventiPerInvitato");
//			q.setParameter("invitato", invitato);
//			List<Evento> list = q.getResultList();
//
//			System.out.println(list.size());			
//		} finally {
//			em.close();
//		}
	}

	public static void addPartecipantiGara(long idEvento, long idPersona) {

		EntityManager em = JpaUtil.getEntityManagerFactory()
				.createEntityManager();

		EntityTransaction t = em.getTransaction();
		try {
			t.begin();

			GaraDiAtletica ev = em.find(GaraDiAtletica.class, idEvento);

		Set<Persona> sp = ev.getSetAtleti();

		sp.add(PersonaDAO.getById(idPersona));	

		for(Persona p: sp) {
			System.out.println(p);
		}
			em.flush();
			t.commit();

		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		} finally {
			em.close();
		}
	}
}
