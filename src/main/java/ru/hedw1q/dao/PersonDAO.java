package ru.hedw1q.dao;

import org.springframework.stereotype.Component;
import ru.hedw1q.models.Person;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hedw1q
 */
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    List<Person> people;
    {
        people=new ArrayList<>();
      people.add(new Person(++PEOPLE_COUNT,23,"Ainur","Ryamov","email@test.net"));
      people.add(new Person(++PEOPLE_COUNT,18,"Kolya","Familievich","213@mail.ru"));
      people.add(new Person(++PEOPLE_COUNT,76,"Electronic","Sharipov","mmm@ya.ru"));
    }
    public List<? extends Person> getPeople(){
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
        initialPerson.setSurname(updatedPerson.getSurname());
        initialPerson.setAge(updatedPerson.getAge());
        initialPerson.setEmail(updatedPerson.getEmail());
    }
    public void delete (int id){
        people.removeIf(person -> person.getId()==id);
    }

}
