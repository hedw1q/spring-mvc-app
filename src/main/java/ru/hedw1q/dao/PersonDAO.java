package ru.hedw1q.dao;

import org.springframework.stereotype.Component;
import ru.hedw1q.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hedw1q
 * @created 19/12/2020
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    List<Person> people;
    {
        people=new ArrayList<>();
      people.add(new Person(++PEOPLE_COUNT,"Ainur"));
      people.add(new Person(++PEOPLE_COUNT,"Kolya"));
      people.add(new Person(++PEOPLE_COUNT,"Electronic"));
    }
    public List<Person> getPeople(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().get();
    }
    public void create(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update (int id, Person updatedPerson){
        Person initialPerson =show(id);
        initialPerson.setName(updatedPerson.getName());
    }
    public void delete (int id){
        people.removeIf(person -> person.getId()==id);
    }

}
