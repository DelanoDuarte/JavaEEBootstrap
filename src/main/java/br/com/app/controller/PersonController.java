package br.com.app.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.app.domain.Person;
import br.com.app.service.PersonService;

@Named
@RequestScoped
public class PersonController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PersonService service;

	private Person person = new Person();

	public String saveNewPerson() {
		try {
			service.savePersonOnDatabase(person);
			return "/pages/person/personList.xhtml";
		} catch (Exception e) {
			return "";
		}

	}

	public List<Person> retrieveAllPersons() {
		try {
			return service.retrieveAllPersons();
		} catch (Exception e) {
			return null;
		}

	}

	/* getters and setters */

	public PersonService getService() {
		return service;
	}

	public void setService(PersonService service) {
		this.service = service;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
