package ru.hedw1q.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

/**
 * @author hedw1q
 */
public class Person {


    public Person() {
    }

    public Person(@PositiveOrZero int id, @PositiveOrZero(message = "Invalid age") int age, @NotEmpty(message = "Empty name") String name, @NotEmpty(message = "Empty surname") String surname, @Email(message = "Not a mail") String email) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    @PositiveOrZero
    private int id;
    @PositiveOrZero(message = "Invalid age")
    private int age;
   @NotEmpty(message = "Empty name")
    private String name;
   @NotEmpty(message = "Empty surname")
    private String surname;
    @Email(message = "Not a mail")
    private String email;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
