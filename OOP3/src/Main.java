import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Automobile a1 = new Automobile("Fiat", "Panda", "Bianco", 3);
        Automobile a2 = new Automobile("Ford", "Fiesta", "Verde", 5);
        Moto m1 = new Moto("Honda", "Hornet", "Nero", 2);
        Camper c1 = new Camper("Laika", "Camping", "Grigio", 5);
        Moto m2 = new Moto("Ducati", "Monster", "Bianco", 1);

        //Veicolo v1 = new Veicolo("Mercedes", "ClasseA", "Nero");

        System.out.println("Veicoli creati: " + Veicolo.getCount());
        System.out.println("Automobili create: " + Automobile.getCount());
        System.out.println("Moto create: " + Moto.getCount());
        System.out.println("Camper creati: " + Camper.getCount());

        System.out.println("*********************************************************");

        Veicolo[] veicoli = new Veicolo[5];
        veicoli[0] = a1;
        veicoli[1] = a2;
        veicoli[2] = m1;
        veicoli[3] = c1;
        veicoli[4] = m2;

        for (int i = 0; i < veicoli.length ; i++) {
            Veicolo v = veicoli[i];
            System.out.println(v.info());
            v.start();

        }

        Smartphone s1 = new Smartphone();
        Smartphone s2 = new Smartphone();

        Navigatore[] arrNav = new Navigatore[4];
        arrNav[0] = a1;
        arrNav[1] = a2;
        arrNav[2] = s1;
        arrNav[3] = s2;

        for (int i = 0; i < arrNav.length ; i++) {
            arrNav[i].aggiornaNavigatore();
        }
    }

}