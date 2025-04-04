package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GestioneIOUser {

    private static Faker fake = new Faker(new Locale("it-IT"));
    private static Logger log = LoggerFactory.getLogger(GestioneIOUser.class);
    private static File file = new File("file/test.txt");
    private static List<User> userList = new ArrayList<User>();

    public static void main(String[] args) {

        try {
            if(userList.size() == 0) {
                leggiDaFile();
            }
            if(userList.size() == 0) {
                caricaUtenti(10);
            }
            stampaUtenti();
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error(e.getMessage());
        }
    }

    public static void caricaUtenti(int n) throws IOException {
        for (int i = 0; i < n; i++) {
            User user = new User(
                    fake.name().firstName(),
                    fake.name().lastName(),
                    fake.address().cityName(),
                    fake.number().numberBetween(18,80)
            );
            //userList.add(user);
            scriviSuFile(user);
            log.info(n + " - Utenti caricati con successo");
        }
    }

    public static void stampaUtenti() {
        System.out.println("Lista Utenti: ");
        userList.forEach(System.out::println);
        System.out.println("Totale utenti: " + userList.size());
    }

    public static void scriviSuFile(User user) throws IOException {
        String u = user.getId() + "," + user.getFirstName() + "," + user.getLastName() + "," +
                user.getCity() + "," + user.getAge() +";";
        FileUtils.writeStringToFile(file, u, "UTF-8", true);
        log.info(user.getFirstName() + " " + user.getLastName() + " scritto correttamente su file");
    }

    public static void leggiDaFile() throws IOException {
        String text = FileUtils.readFileToString(file, "UTF-8");
        if(text != "") {
            String[] row = text.split(";");
            for (String r : row) {
                String[] props = r.split(",");
                User user = new User(
                        Integer.parseInt(props[0]),
                        props[1],
                        props[2],
                        props[3],
                        Integer.parseInt(props[4]));
                userList.add(user);
            }
        }
    }
}
