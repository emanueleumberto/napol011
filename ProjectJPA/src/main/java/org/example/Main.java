package org.example;

import com.github.javafaker.Faker;
import org.example.dao.CompanyDAO;
import org.example.dao.CourseDAO;
import org.example.dao.PassportDAO;
import org.example.dao.UserDAO;
import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Main {

    // Connection conn = DriverManager.getConnection("url", "user", "pass");
    // Statement st = conn.createStatement();

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectJPA");
    private static EntityManager em = emf.createEntityManager();

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static UserDAO userDAO = new UserDAO();
    private static PassportDAO passportDAO = new PassportDAO();
    private static CompanyDAO companyDAO = new CompanyDAO();
    private static CourseDAO courseDAO = new CourseDAO();

    public static void main( String[] args ) {

        //createUser(10);

        //Company c = new Company("ITConsulting");
        //companyDAO.saveCompany(c);

        //Course co = new Course("Java", 80);
        //courseDAO.saveCourse(co);

        User u = userDAO.getUser(3);
        //Company c = companyDAO.getCompany(1);
        //Course java = courseDAO.getCourse(1);
        //u.getCourses().add(java);
        //u.setCompany(c);
        //userDAO.saveUser(u);

        //Passport p = new Passport(1, LocalDate.now(), u);
        //passportDAO.savePassport(p);

        System.out.println(u);
        System.out.println(u.getPassport());
        System.out.println(u.getCompany());
        System.out.println(u.getCourses());


    }

    public static void createUser(int num) {
        for (int i = 0; i < num ; i++) {
            Address address = new Address(
                                    fake.address().streetAddress(),
                                    fake.address().cityName(),
                                    fake.address().state());
            User user = new User(
                        fake.name().firstName(),
                        fake.name().lastName(),
                        fake.number().numberBetween(18,80),
                        fake.internet().emailAddress(),
                        fake.internet().password(),
                        address);
            userDAO.saveUser(user);
        }
    }


}
