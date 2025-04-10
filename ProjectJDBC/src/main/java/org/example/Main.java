package org.example;

import java.sql.SQLException;
import java.util.List;

public class Main
{
    public static void main( String[] args ) {
        try {
            // Db Connection
            DBConnection db = new DBConnection();

            // Created User
            //User u1 = new User("Mario", "Rossi", "Roma", 20, "m.rossi@example.com", "qwerty");
            //db.createUser(u1);
            //User u2 = new User("Giuseppe", "Verdi", "Milano", 31, "g.verdi@example.com", "qwerty");
            //db.createUser(u2);
            //User u3 = new User("Francesca", "Neri", "Napoli", 25, "f.neri@example.com", "qwerty");
            //db.createUser(u3);

            // Read User
            //User u = db.findUser(1);
            //System.out.println(u);

            // Modified User
            //u.setPassword("Pa$$w0rd!");
            //db.updateUser(u);

            // Deleted User
            //db.removeUser(u);

            // Read All
            List<User> users = db.findAll();
            users.forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
