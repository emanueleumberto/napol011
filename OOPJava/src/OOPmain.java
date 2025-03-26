public class OOPmain {

    public static void main(String[] args) {
        System.out.println("Run Main...");

        Automobile a1 = new Automobile("Fiat", "Panda",1000,"Nero", TipoAlimentazione.DIESEL);
        /*a1.marca = "Fiat";
        a1.modello = "Panda";
        a1.cilindrata = 1000;
        a1.colore = "Nero";*/
        a1.targa = "AB123CD";
        //a1.start();
        a1.info();
        System.out.println(a1);

        System.out.println("***************************");

        Automobile a2 = new Automobile("Mercedes", "ClasseB",  1500, "Bianco", TipoAlimentazione.ELETTRICO, "EF456GH");
        /*a2.marca = "Mercedes";
        a2.modello = "ClasseB";
        a2.colore = "Bianco";
        a2.cilindrata = 1500;
        a2.targa = "EF456GH";*/
        //a2.info();
        System.out.println(a2);

        System.out.println("***************************");

        Automobile a3 = a2; // Creo un puntatore alla zona di memoria di a2
        System.out.println(a3);
        //a3.start();
        //a3.info();
        //a2.info();


    }

}
