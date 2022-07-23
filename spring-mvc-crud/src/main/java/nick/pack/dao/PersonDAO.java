package nick.pack.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nick.pack.model.Person;

@Component
public class PersonDAO {
	private final List<Person> personList = new ArrayList();
	{
		personList.add(new Person(1, "Andrey"));
		personList.add(new Person(2, "Maxim"));
		personList.add(new Person(3, "Pavel"));
		personList.add(new Person(4, "Viktor"));
	}
	public void add(Person person) {
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
	public void delete(Person person) {
		personList.remove(person);
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
