package ru.hedw1q.dao;

import org.springframework.stereotype.Component;
import ru.hedw1q.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hedw1q
 */
@Component
public class PersonDBService {
    private static final String URL="jdbc:postgresql://localhost:5432/springmvcapp_db";
    private static final String LOGIN="postgres";
    private static final String PASSWORD="admin" ;
    private static Connection connection;

    static {
        try {
            connection= DriverManager.getConnection(URL,LOGIN,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<? extends Person> getPeople(){
        List <Person> people=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();
            String SQL="select * from public.\"Person\"";
            ResultSet resultSet= statement.executeQuery(SQL);
           while(resultSet.next()){
               Person person=new Person();
               person.setId(resultSet.getInt("id"));
               person.setName(resultSet.getString("name"));
               person.setSurname(resultSet.getString("surname"));
               person.setAge(resultSet.getInt("age"));
               person.setEmail(resultSet.getString("email"));
               people.add(person);
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
return people;
    }

    public Person show(int id){
    //    return people.stream().filter(person -> person.getId()==id).findAny().get();
        return null;
    }
    public void create(Person person){
        try {
            Statement statement=connection.createStatement();
            String SQL="insert into public.\"Person\" values("+person.getId()+",'"+person.getName()+"','"+person.getSurname()+"',"
                    +person.getAge()+",'"+person.getEmail()+"')";
            statement.executeQuery(SQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void update (int id, Person updatedPerson){
//        Person initialPerson =show(id);
//        initialPerson.setName(updatedPerson.getName());
//        initialPerson.setSurname(updatedPerson.getSurname());
//        initialPerson.setAge(updatedPerson.getAge());
//        initialPerson.setEmail(updatedPerson.getEmail());
    }
    public void delete (int id){
//        people.removeIf(person -> person.getId()==id);
    }

}
