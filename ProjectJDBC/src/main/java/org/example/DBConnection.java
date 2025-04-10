package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {

    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "napol011jdbc";
    private Statement st;
    private Connection conn;

    public DBConnection() throws SQLException {
        conn = DriverManager.getConnection(url, user, pass);
        st = conn.createStatement();
        createDatabase();
        createTableUsers();
    }

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        st.executeUpdate(sql);
        System.out.println("Db " + dbName + " connect!!!");
        conn = DriverManager.getConnection(url+dbName, user, pass);
        st = conn.createStatement();
    }

    private void createTableUsers() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "user_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "firstname VARCHAR(50) NOT NULL," +
                "lastname VARCHAR(50) NOT NULL," +
                "city VARCHAR(50) NULL," +
                "age INT UNSIGNED NULL," +
                "email VARCHAR(100) NOT NULL UNIQUE," +
                "password VARCHAR(50) NOT NULL);";
        st.executeUpdate(sql);
        System.out.println("Table users created!!!");
    }

    // CRUD -> Create Read Update Delete
    public void createUser(User user) throws SQLException {
        /*String sql = "INSERT INTO users (firstname, lastname, city, age, email, password) " +
                "VALUES ('"+user.getFirstname()+"', '" + user.getLastname()+ "', '"+user.getCity()+"'," +
                user.getAge() + ", '"+user.getEmail()+"', '"+user.getPassword()+"')";
        st.executeUpdate(sql);*/

        String sql = "INSERT INTO users (firstname, lastname, city, age, email, password) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getFirstname());
        ps.setString(2, user.getLastname());
        ps.setString(3, user.getCity());
        ps.setInt(4, user.getAge());
        ps.setString(5, user.getEmail());
        ps.setString(6, user.getPassword());
        ps.executeUpdate();
        System.out.println(user.getFirstname() + " " + user.getLastname() + " created!!");
    }

    public User findUser(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = " + id;
        ResultSet rs = st.executeQuery(sql);

        if(rs.next()) {
            int user_id = rs.getInt("user_id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String city = rs.getString("city");
            int age = rs.getInt("age");
            String email = rs.getString("email");
            String password = rs.getString("password");

            return new User(user_id, firstname, lastname, city, age, email, password);
        }

        return null;

    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET firstname = ?, lastname = ?, city = ?, " +
                     "age = ?, email = ?, password = ? WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, user.getFirstname());
        ps.setString(2, user.getLastname());
        ps.setString(3, user.getCity());
        ps.setInt(4, user.getAge());
        ps.setString(5, user.getEmail());
        ps.setString(6, user.getPassword());
        ps.setLong(7, user.getUser_id());
        ps.executeUpdate();
        System.out.println(user.getFirstname() + " " + user.getLastname() + " modified!!");
    }

    public void removeUser(User user) throws SQLException {
        String sql = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, user.getUser_id());
        ps.executeUpdate();
        System.out.println(user.getFirstname() + " " + user.getLastname() + " deleted!!");
    }

    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM users";
        ResultSet rs = st.executeQuery(sql);

        List<User> lista = new ArrayList<User>();
        while(rs.next()) {
            int user_id = rs.getInt("user_id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String city = rs.getString("city");
            int age = rs.getInt("age");
            String email = rs.getString("email");
            String password = rs.getString("password");

            lista.add(new User(user_id, firstname, lastname, city, age, email, password));
        }
        return lista;
    }
}
