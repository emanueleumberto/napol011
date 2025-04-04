package org.example;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class Main 
{
    private static File file = new File("file/test.txt");

    public static void main( String[] args ) {

        Logger log = LoggerFactory.getLogger(Main.class);

        Faker fake = new Faker(new Locale("it-IT"));
        String name = fake.name().firstName();
        String lastname = fake.name().lastName();
        String city = fake.address().cityName();
        int age = fake.number().numberBetween(18,80);

        /*System.out.println("Ciao " + name + " " + lastname + " ("+ city +") age: " + age);

        log.debug("Sono la dipendenza Logger");
        log.info("Sono la dipendenza Logger");
        log.warn("Sono la dipendenza Logger");
        log.error("Sono la dipendenza Logger");*/

        // Gestione I/O su file
        // Apache Commons IO

        // Stringa newLine per andare a capo
        String newLine = System.lineSeparator();

        try {
            scriviSuFile("Ciao a tutti" + newLine);
            //scriviSuFile("Altro testo\n");
            String testo = leggiDaFile();
            System.out.println(testo);
            rimuoviFile();
            rimuoviDirectory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void scriviSuFile(String str) throws IOException {
        //File file = new File("file/test.txt");
        FileUtils.writeStringToFile(file, str, "UTF-8", true);
        System.out.println("Testo scritto correttamente su file");
    }

    public static String leggiDaFile() throws IOException {
        //File file = new File("file/test.txt");
        return FileUtils.readFileToString(file, "UTF-8");
    }

    public static void rimuoviFile() {
        FileUtils.deleteQuietly(file);
        System.out.println("File di testo eliminato!!");
    }

    public static void rimuoviDirectory() throws IOException {
        File file = new File("file/");
        FileUtils.deleteDirectory(file);
        System.out.println("Directory eliminata!!");
    }

}
