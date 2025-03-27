public class Main {

    public static void main(String[] args) {

        System.out.println("Hello world!");
        Animal a1 = new Animal("Bobby", 3, "Dog", "Labrador");
        /*a1.name = "Bobby";
        a1.age = 3;
        a1.type = "Dog";
        a1.category = "Labrador";*/

        a1.info();

        a1.setName("Tom");
        a1.info();
        /*System.out.println(a1.getName());
        System.out.println(a1.getAge());*/


        // Un linguaggio OOP si poggia su 4 concetti fondamentali
        // - Incapsulamento
        // - Ereditarietà
        // - Astrazione
        // - Polimorfismo

        // Modificatori di accesso
        // public | private | protected | package o default -> incapsulamento


        // Ereditarietà
        Automobile auto1 = new Automobile("Fiat", "Panda", "AB123CD", 3);
        Moto moto1 = new Moto("Honda", "Hornet", "CD456EF", 2);
        Camper camper1 = new Camper("Laika", "Camping", "XZ987WQ", 5);

        /*Automobile[] arrAuto = new Automobile[5];
        arrAuto[0] = auto1;
        //arrAuto[1] = moto1;
        //arrAuto[2] = camper1;

        Moto[] arrMoto = new Moto[5];
        arrMoto[0] = moto1;
        //arrMoto[1] = auto1;
        //arrMoto[2] = camper1;

        Camper[] arrCamper = new Camper[5];
        arrCamper[0] = camper1;
        //arrCamper[1] = moto1;
        //arrCamper[2] = auto1;*/

        Veicolo[] arrVeicoli = new Veicolo[4];
        arrVeicoli[0] = auto1;
        arrVeicoli[1] = moto1;
        arrVeicoli[2] = camper1;
        arrVeicoli[3] = auto1;

        for (int i=0; i<arrVeicoli.length; i++) {
            Veicolo v = arrVeicoli[i];
            if(v instanceof Automobile) {
                Automobile a = (Automobile) v;
                System.out.println(a.infoAutomobile());
            } else if(v instanceof Moto) {
                Moto m = (Moto) v;
                System.out.println(m.infoMoto());
            } else if(v instanceof Camper) {
                Camper c = (Camper) v;
                System.out.println(c.infoCamper());
            } else {
                System.out.println("Sono un ???");
            }
        }


    }

}