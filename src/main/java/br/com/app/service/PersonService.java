package br.com.app.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.app.domain.Person;

@Stateless
public class PersonService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	public Person savePersonOnDatabase(Person person) {
		return em.merge(person);
	}

	public List<Person> retrieveAllPersons() {
		return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
	}
}
