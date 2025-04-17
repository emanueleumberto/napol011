package com.example.IntroSpring.classes;

public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String city;
    private Integer age;

    public User() {}

    public User(String firstname, String lastname, String city, Integer age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
