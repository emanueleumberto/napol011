package com.example.IntroSpring.Esercizio;

import com.example.IntroSpring.Esercizio.classes.Menu;
import com.example.IntroSpring.Esercizio.configurations.PizzeriaConfig;
import com.example.IntroSpring.configurations.UserConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainPizzeria implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Pizzeria Runner....");

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(PizzeriaConfig.class);

        Menu menu = (Menu) appContext.getBean("creaMenu");
        menu.stampaMenu();

        appContext.close();
    }

}
