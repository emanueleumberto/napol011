package org.example.Esercizio_0404;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class GestioneOfficina {

    private static Officina off;
    private static Faker fake = new Faker(new Locale("it-IT"));
    private static File file = new File("file/veicoli.txt");
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        /*Veicolo v1 = new Veicolo("AB123CD", "Fiat", "Panda", 2010);
        Veicolo v2 = new Veicolo("EF456GH", "Ford", "Fiesta", 2016);
        Veicolo v3 = new Veicolo("IL789MN", "Renault", "Clio", 2020);
        off.aggiungiVeicolo(v1);
        off.aggiungiVeicolo(v2);
        off.aggiungiVeicolo(v3);
        Veicolo v = off.cercaVeicolo("EF456GH").get();
        v.aggiungiIntervento("Tagliando completo");
        v.aggiungiIntervento("Sostituzione Gomme");
        off.rimuoviVeicolo("EF456GH");
        List<Veicolo> listaFiltrata = off.filtraVeicoliPerMarca("Ford");
        listaFiltrata.forEach(System.out::println);
        */



        // Leggi Veicoli da file
        /*Map<String, Veicolo> mappaVeicoli = FileManager.leggiVeicoliDaFile(file);
        if(mappaVeicoli != null) {
            off = new Officina("Officina F.lli Rossi", mappaVeicoli);
        } else {
            off = new Officina("Officina F.lli Rossi");
        }*/

        // Genera veicoli e interventi fake
        //creaVeicoliOfficina(14);
        //generaInterventiVeicoli(25);

        // Aggiungi Veicolo
        //Veicolo v2 = new Veicolo("EF456GH", "Ford", "Fiesta", 2016);
        //off.aggiungiVeicolo(v2);

        // Registra un intervento di manutenzione
        //Veicolo v = off.cercaVeicolo("IK798SB").get();
        //v.aggiungiIntervento("Tagliando completo");

        // Rimuovi veicolo
        //off.rimuoviVeicolo("WD225DW");

        // Filtra veicoli per targa
        // off.filtraVeicoliPerMarca("Ford").forEach(System.out::println);

        // Salva veicoli su file
        /*try {
            FileManager.scriviVeicoliSuFile(file, off.getVeicoli());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        // Visualizza tutti i veicoli
        //System.out.println(off.getNomeOfficina());
        //off.visualizzaVeicoli();

        while(true) {
            stampaMenu();
            System.out.print("Cosa vuoi fare? ");
            int scelta;
            try {
                scelta = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Valore errato!!!");
                //scelta = 0;
                continue;
            }

            switch (scelta) {
                case 1:
                    Map<String, Veicolo> mappaVeicoli = FileManager.leggiVeicoliDaFile(file);
                    off = new Officina("Officina F.lli Rossi", mappaVeicoli);
                    System.out.println("Valori letti dal file correttamente");
                    break;
                case 2:
                    System.out.println("Vuoi aggiungere un veicolo? ");
                    System.out.print("Inserisci la Targa: ");
                    String targa = scan.nextLine();
                    System.out.print("Inserisci la Marca: ");
                    String marca = scan.nextLine();
                    System.out.print("Inserisci il modello: ");
                    String modello = scan.nextLine();
                    System.out.print("Inserisci anno di immatricolazione: ");
                    int annoImmatricolazione = Integer.parseInt(scan.nextLine());
                    off.aggiungiVeicolo(
                            new Veicolo(targa, marca,modello,annoImmatricolazione));
                    System.out.println("Veicolo aggiunto in officina");
                    break;
                case 3:
                    System.out.println("Vuoi cercare un veicolo? ");
                    System.out.print("Inserisci la Targa: ");
                    targa = scan.nextLine();
                    Veicolo v = off.cercaVeicolo(targa).get();
                    System.out.println(v);
                    break;
                case 4:
                    System.out.println("Vuoi registrare un intervento di manutenzione? ");
                    System.out.print("Inserisci la Targa: ");
                    targa = scan.nextLine();
                    System.out.print("Inserisci l'intervento da fare sul veicolo: ");
                    String intevento = scan.nextLine();
                    v = off.cercaVeicolo(targa).get();
                    v.aggiungiIntervento(intevento);
                    System.out.println("Intervento di manutenzione aggiunto al veicolo");
                    break;
                case 5:
                    System.out.println("Vuoi filtrare i veicoli presenti in officina? ");
                    System.out.print("Inserisci la Marca: ");
                    marca = scan.nextLine();
                    off.filtraVeicoliPerMarca(marca).forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Vuoi rimuovere un veicolo? ");
                    System.out.print("Inserisci la Targa: ");
                    targa = scan.nextLine();
                    off.rimuoviVeicolo(targa);
                    System.out.println("Rimozione del Veicolo in officina");
                    break;
                case 7:
                    if(off == null) {
                        off = new Officina("Officina F.lli Rossi");
                    }
                    System.out.println(off.getNomeOfficina());
                    off.visualizzaVeicoli();
                    break;
                case 8:
                    try {
                        FileManager.scriviVeicoliSuFile(file, off.getVeicoli());
                    } catch (IOException e) {
                        System.err.println("Errore nel salvataggio dei dati sul file");
                    }
                    break;
                case 9:
                    off.getVeicoli()
                            .values()
                            .stream()
                            .sorted(Comparator.comparingInt(Veicolo::getAnnoImmatricolazione))
                            .forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Termine programma");
                    return;
                default:
                    System.out.println("Valore errato!!");
            }
        }

    }

    public static void creaVeicoliOfficina(int numVeicoli) {
        Veicolo v1 = new Veicolo("AB123CD", "Fiat", "Panda", 2010);
        off.aggiungiVeicolo(v1);

        String[] marche = {"Fiat", "Ford", "Renault", "Bmw", "Mercedes", "Kia"};
        String[] modelli = {"Panda", "Fiesta", "Punto", "Clio", "SerieA", "Abc", "SuperAuto"};

        for (int i = 0; i < numVeicoli; i++) {
            String marca = marche[fake.number().numberBetween(0, marche.length)];
            String modello = modelli[fake.number().numberBetween(0, modelli.length)];
            String targa =  fake.letterify("??").toUpperCase() +
                    fake.number().numberBetween(100,999) +
                    fake.letterify("??").toUpperCase();
            int annoImmatricolazione = fake.number().numberBetween(1990,2025);
            Veicolo v = new Veicolo(targa, marca, modello, annoImmatricolazione);
            off.aggiungiVeicolo(v);
        }
    }

    public static void generaInterventiVeicoli(int numInterventi) {
        String[] interventi = {"Tagliando", "Sostituzione Gomme", "Cambio Fari", "Riparazione cambio", "Riparazione motore", "Sostizione Batteria"};
        List<String> targhe = off.getVeicoli().keySet().stream().toList();

        for (int i = 0; i < numInterventi; i++) {
            Veicolo v = off.cercaVeicolo(targhe.get(fake.number().numberBetween(0, targhe.size()))).get();
            v.aggiungiIntervento(interventi[fake.number().numberBetween(0, interventi.length)]);
        }
    }

    public static void stampaMenu() {
        // Menu interattivo per la gestione dei veicoli in officina
        System.out.println("1 - Carica i veicoli da file");
        System.out.println("2 - Aggiungi un nuovo veicolo");
        System.out.println("3 - Cerca un veicolo per targa");
        System.out.println("4 - Registra un intervento di manutenzione su un veicolo");
        System.out.println("5 - Filtra i veicoli per marca");
        System.out.println("6 - Rimuovi un veicolo per targa");
        System.out.println("7 - Visualizzare tutti i veicoli");
        System.out.println("8 - Salvare i veicoli su file");
        System.out.println("9 - Ordina per anno di immatricolazione");
        System.out.println("0 - Termina programma");
    }

}
