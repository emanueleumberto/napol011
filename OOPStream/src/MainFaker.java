import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainFaker {
    static Faker fake = new Faker(new Locale("it-IT"));
    static List<User> listaUtenti = new ArrayList<User>();

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(MainFaker.class);
        logger.info("Hello World");

        //String name = fake.name().firstName();
        //creaUtenti(10);
        //listaUtenti.forEach(System.out::println);

    }

    public static void creaUtenti(int num) {

        for (int i = 0; i < num; i++) {
            String name = fake.name().firstName();
            String lastname = fake.name().lastName();
            int age = fake.number().numberBetween(18,80);
            String city = fake.address().cityName();

            User u = new User(name, lastname, city, age);
            listaUtenti.add(u);
        }

    }

}
