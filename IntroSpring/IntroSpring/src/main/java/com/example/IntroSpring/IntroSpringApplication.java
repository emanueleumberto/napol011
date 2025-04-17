package com.example.IntroSpring;

import com.example.IntroSpring.classes.User;
import com.example.IntroSpring.components.UserComponent;
import com.example.IntroSpring.configurations.UserConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class IntroSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(IntroSpringApplication.class, args);
		System.out.println("SpringBoot App...");

		// Per creare istanze in una Applicazione Spring possiamo utilizzare:
		// -> Configurazione di beans tramite file XML
		//		configWithXML();

		// -> Configurazione di beans tramite classe con Annotation @Configuration
		//		configWithConfiguration();

		// -> Configurazione tramite Annotations sulla classe Pojo
		//		configWithComponent();

	}

	public static void configWithXML() {
		// Creo un Application Context dove gestire il ciclo di vita di un bean
		// creato tramite il file di configurazione XML
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("configuration_beans.xml");

		// Creazione di un bean tramite il costruttore
		User userXml1 = (User) appContext.getBean("beanUser");
		System.out.println(userXml1);

		User userXml2 = (User) appContext.getBean("beanUserSetter");
		System.out.println(userXml2);

		// Chiudo il Application Context
		appContext.close();

	}

	public static void configWithConfiguration() {
		// Creo un Application Context dove gestire il ciclo di vita di un bean
		// creato tramite la classe di configurazione
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(UserConfiguration.class);

		// Creazione di un bean tramite il costruttore
		User userConfig = (User) appContext.getBean("adminUser");
		System.out.println(userConfig);

		// Creazione di un bean tramite il costruttore
		User userCustomConfig = (User) appContext.getBean("customUser", "Giuseppe", "Verdi", "Napoli", 21);
		System.out.println(userCustomConfig);

		// Chiudo il Application Context
		appContext.close();
	}

	public static void configWithComponent() {
		// Creo un Application Context dove gestire il ciclo di vita di un bean
		// creato tramite la classe di configurazione
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();

		appContext.scan("com.example.IntroSpring.components");
		appContext.refresh();

		// Creazione di un bean tramite il costruttore
		UserComponent userComponent = (UserComponent) appContext.getBean("user_component");
		userComponent.setFirstname("Mario");
		userComponent.setLastname("Rossi");
		userComponent.setCity("Roma");
		userComponent.setAge(45);
		System.out.println(userComponent);

		UserComponent userComponent2 = (UserComponent) appContext.getBean("user_component", "Giuseppe", "Verdi", "Napoli", 21);
		System.out.println(userComponent2);
	}
}
