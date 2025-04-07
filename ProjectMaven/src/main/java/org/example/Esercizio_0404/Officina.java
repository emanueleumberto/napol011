package org.example.Esercizio_0404;

import java.util.*;

public class Officina {

    private String nomeOfficina;
    private Map<String, Veicolo> veicoli;

    public Officina(String nomeOfficina) {
        this.nomeOfficina = nomeOfficina;
        this.veicoli = new HashMap<String, Veicolo>();
    }

    public Officina(String nomeOfficina, Map<String, Veicolo> veicoli) {
        this.nomeOfficina = nomeOfficina;
        this.veicoli = veicoli;
    }

    public String getNomeOfficina() { return nomeOfficina; }
    public Map<String, Veicolo> getVeicoli() { return veicoli; }

    public void aggiungiVeicolo(Veicolo veicolo) {
        if(veicolo != null) {
            this.veicoli.put(veicolo.getTarga(), veicolo);
        }
    }

    public void rimuoviVeicolo(String targa) {
        if(this.veicoli.remove(targa) == null) {
            throw new NoSuchElementException("Veicolo non trovato nell'officina");
        }
    }

    public Optional<Veicolo> cercaVeicolo(String targa) {
        if(this.veicoli.get(targa) == null) {
            throw new NoSuchElementException("Veicolo non trovato nell'officina");
        }
        return Optional.ofNullable(this.veicoli.get(targa));
    }

    public void visualizzaVeicoli() {
        /*Set<String> keys = this.veicoli.keySet();
        for (String k : keys) {
            System.out.println(this.veicoli.get(k));
        }*/

        //this.veicoli.forEach((k,v) -> System.out.println(v));

        this.veicoli.values().forEach(System.out::println);
    }

    public List<Veicolo> filtraVeicoliPerMarca(String marca) {
        return this.veicoli.values()
                            .stream()
                            .filter(v -> v.getMarca().equals(marca))
                            .toList();
    }

    @Override
    public String toString() {
        return "Officina{" +
                "nomeOfficina='" + nomeOfficina + '\'' +
                ", veicoli=" + veicoli +
                '}';
    }
}
