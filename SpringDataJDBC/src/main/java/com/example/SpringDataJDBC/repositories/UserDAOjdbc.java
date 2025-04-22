package com.example.SpringDataJDBC.repositories;

import com.example.SpringDataJDBC.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDAOjdbc implements UserDAORepository {

    @Autowired JdbcTemplate jdbc;

    @Override
    public void insertUser(User user) {
        String sql = "INSERT INTO users (firstname, lastname, city, age, email) " +
                                        "VALUES (?, ?, ?, ?, ?)";
        jdbc.update(sql,
                user.getFirstname(),
                user.getLastname(),
                user.getCity(),
                user.getAge(),
                user.getEmail());
    }

    @Override
    public User getUser(long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbc.queryForObject(sql,new UserRowMapper(),id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET firstname=?, lastname=?, city=?, age=?, email=? WHERE id=?";
        jdbc.update(sql,
                user.getFirstname(),
                user.getLastname(),
                user.getCity(),
                user.getAge(),
                user.getEmail(),
                user.getId());
    }

    @Override
    public void removeUser(User user) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbc.update(sql,user.getId());
    }

    @Override
    public List<User> getAllUser() {
        String sql = "SELECT * FROM users";
        return jdbc.query(sql, new UserRowMapper());
    }
}
