package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() {
		logger.info("Finding all people!");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}

	public Person create(Person person) {
		logger.info("Create one person!");

		return person;
	}

	public Person update(Person person) {
		logger.info("Update one person!");

		return person;
	}
	
	public void delete(String id) {
		logger.info("Delete one person!");

	}

	public Person findById(String id) {

		logger.info("Finding on person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFristName("Lenadro");
		person.setLastName("Costa");
		person.setAddress("Uberlândia - Minas Gerais - Brasil");
		person.setGender("Male");
		return person;
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFristName("Person name " + i);
		person.setLastName("Last Name " + i);
		person.setAddress("Some Address in Brasil");
		person.setGender("Male");
		return person;
	}

}
