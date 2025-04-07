package org.example.Esercizio_0404;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FileManager {



    public static Map<String, Veicolo> leggiVeicoliDaFile(File filePath) {

        Map<String, Veicolo> mappaVeicoli = new HashMap<String, Veicolo>();

        try {
            String veicoliDaFile = FileUtils.readFileToString(filePath, "UTF-8");
            String[] rows = veicoliDaFile.split(System.lineSeparator());

                for (String row : rows) {
                    String[] rowParams = row.split(",");
                    if(rowParams.length > 1) {
                    Veicolo v = new Veicolo(
                            rowParams[0],
                            rowParams[1],
                            rowParams[2],
                            Integer.parseInt(rowParams[3]));
                    if (rowParams.length > 4) {
                        String[] interventi = rowParams[4].split("-");
                        for (String intervento : interventi) {
                            v.aggiungiIntervento(intervento);
                        }

                        //Arrays.stream(interventi).forEach(v::aggiungiIntervento);

                    }
                        mappaVeicoli.put(v.getTarga(), v);
                    }

            }

        } catch (IOException e) {
            //throw new RuntimeException(e);
            System.err.println("File non esiste");
        }

        return mappaVeicoli;
    }

    public static void scriviVeicoliSuFile(File filePath, Map<String, Veicolo> veicoli) throws IOException {
        FileUtils.writeStringToFile(filePath, "" , "UTF-8");
        veicoli.values().forEach(v -> {
            String vStr =   v.getTarga() + "," +
                            v.getMarca() + "," +
                            v.getModello() + "," +
                            v.getAnnoImmatricolazione() + "," +
                            String.join("-", v.getInterventiManutenzione()) + System.lineSeparator();

            try {
                FileUtils.writeStringToFile(filePath, vStr , "UTF-8", true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
