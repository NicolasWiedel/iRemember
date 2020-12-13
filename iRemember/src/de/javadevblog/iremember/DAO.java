package de.javadevblog.iremember;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.javadevblog.iremember.model.adresses.Person;

public class DAO {

	protected EntityManagerFactory factory;
	protected EntityManager em;
	
	public DAO() {
		factory = Persistence.createEntityManagerFactory("iRemember");
		em = factory.createEntityManager();
	}
	
	public void shutdown() {
		em.close();
		factory.close();
		em = null;
		factory = null;
	}
	
//	DAO-Methoden für Zugriff auf Adressen
	@SuppressWarnings("unchecked")
	public Collection<Person> findAll(){
		Query query = em.createQuery("SELECT p FROM Person p");
		Collection<Person> collection;
		collection = (Collection<Person>) query.getResultList();
		return collection;
	}
	
	public Person findById(long id) {
		return em.find(Person.class, id);
	}
	
	public Person findByFistName(String firstName) {
		Person person = (Person) em.createQuery("SELECT p FROM Person p WHERE p.firstName = :fn")
				.setParameter("fn", firstName)
				.getSingleResult();
		return person;
	}
	
	public Person findByLastName(String lastName) {
		Person person = (Person) em.createQuery("SELECT p FROM Person p WHERE p.lastName = :ln")
				.setParameter("ln", lastName)
				.getSingleResult();
		return person;
	}
	
	public void persist(Person person) {
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
	}
	
	public void delete(long id) {
		em.getTransaction();
		Person person = em.getReference(Person.class, id);
		em.remove(person);
		em.getTransaction().commit();
	}
//	ENDE DAO-Methoden für Zugriff auf Adressen
}
