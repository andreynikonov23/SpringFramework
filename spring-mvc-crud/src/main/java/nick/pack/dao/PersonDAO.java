package nick.pack.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nick.pack.model.Person;

@Component
public class PersonDAO {
	private static int PEOPLE_ID;
	private final List<Person> personList = new ArrayList();
	{
		personList.add(new Person(++PEOPLE_ID, "Andrey"));
		personList.add(new Person(++PEOPLE_ID, "Maxim"));
		personList.add(new Person(++PEOPLE_ID, "Pavel"));
		personList.add(new Person(++PEOPLE_ID, "Viktor"));
	}
	public void add(Person person) {
		person.setId(++PEOPLE_ID);
		personList.add(person);
	}
	public void update(Person person) {
		for(int i=0; i < personList.size(); i++) {
			if (personList.get(i).getId() == person.getId()) {
				personList.remove(i);
				break;
			}
		}
	}
	public void delete(int id) {
		for (Person person : personList) {
			if (person.getId() == id) {
				personList.remove(person);
				break;
			}
		}
	}
	public List<Person> findAll(){
		return personList;
	}
	public Person findById(int id) {
		Person result = null;
		for (Person person : personList) {
			if (person.getId() == id){
				result = person;
				break;
			}
		}
		return result;
	}
}
