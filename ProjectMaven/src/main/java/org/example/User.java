package org.example;

public class User {

    private static int count = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private int age;

    public User(String firstName, String lastName, String city, int age) {
        this.id = ++count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
    }

    public User(int id, String firstName, String lastName, String city, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
