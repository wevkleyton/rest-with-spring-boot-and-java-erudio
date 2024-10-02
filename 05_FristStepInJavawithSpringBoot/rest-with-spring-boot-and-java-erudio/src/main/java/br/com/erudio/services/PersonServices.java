package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Finding all people!");
		return repository.findAll();
	}

	public Person create(Person person) {
		logger.info("Create one person!");
		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("Update one person!");
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No recordes found this ID!"));
		
		entity.setFristName(person.getFristName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
				
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		logger.info("Delete one person!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No recordes found this ID!"));
		repository.delete(entity);


	}

	public Person findById(Long id) {

		logger.info("Finding on person!");
		
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}

//	private Person mockPerson(int i) {
//		Person person = new Person();
//		person.setId(counter.incrementAndGet());
//		person.setFristName("Person name " + i);
//		person.setLastName("Last Name " + i);
//		person.setAddress("Some Address in Brasil");
//		person.setGender("Male");
//		return person;
//	}

}
