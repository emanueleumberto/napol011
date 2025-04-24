package com.example.SpringDataJPA.repositories;

import com.example.SpringDataJPA.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAORepository extends JpaRepository<User, Long> {
    /*public List<User> findByCity(String city);*/
    public List<User> findByFirstnameAndLastname(String firstname, String lastname);
    public List<User> findByAgeBetween(Integer min, Integer max);
    /*public List<User> findByCityNot(String city);*/
    public List<User> findByEmailLike(String parteEmail);
    public boolean existsByEmail(String  email);

    /*@Query("SELECT u FROM User u WHERE u.getFirstname().length() > :l")
    public List<User> nameLength(Integer l);*/
}
