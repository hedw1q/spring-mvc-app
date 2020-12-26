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
        Person person=null;
        String SQL="SELECT * FROM public.\"Person\" WHERE id=?";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SQL);
            preparedStatement.setInt(1, id);
            ResultSet resultSet= preparedStatement.executeQuery();
            resultSet.next();

            person=new Person();

            person.setId(id);
            person.setName(resultSet.getString("name"));
            person.setSurname(resultSet.getString("surname"));
            person.setAge(resultSet.getInt("Age"));
            person.setEmail(resultSet.getString("email"));

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;

    }
    public void create(Person person){
        String SQL="INSERT INTO public.\"Person\"(name,surname,age,email) VALUES(?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SQL);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setInt(3,person.getAge());
            preparedStatement.setString(4,person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void update (int id, Person updatedPerson){
   String SQL="UPDATE public.\"Person\" SET name=?,surname=?,age=?,email=? WHERE id=?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SQL);

            preparedStatement.setString(1, updatedPerson.getName());
            preparedStatement.setString(2, updatedPerson.getSurname());
            preparedStatement.setInt(3,updatedPerson.getAge());
            preparedStatement.setString(4,updatedPerson.getEmail());
            preparedStatement.setInt(5,id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void delete (int id){
        String SQL="DELETE from public.\"Person\" WHERE id=?";
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SQL);

            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
