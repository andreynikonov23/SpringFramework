package nick.pack.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nick.pack.model.Person;

@Component
public class PersonDAO {
	private final List<Person> people = new ArrayList<Person>();
	
	
	
	public PersonDAO() {
		people.add(new Person(1, "John"));
		people.add(new Person(2, "Sam"));
		people.add(new Person(3, "Henry"));
		people.add(new Person(4, "Lloyd"));
	}
	
	public List<Person> getPeople(){
		return people;
	}
	public Person getById(int id) {
		Person person = null;
		for (Person pers : people) {
			if (pers.getId() == id) {
				person = pers;
			}
		}
		return person;
	}
}
