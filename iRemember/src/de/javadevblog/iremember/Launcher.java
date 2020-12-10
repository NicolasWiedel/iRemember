package de.javadevblog.iremember;

import java.sql.Date;
import java.util.Calendar;

import de.javadevblog.iremember.model.adresses.Person;
import de.javadevblog.iremember.model.adresses.PersonDAO;
import de.javadevblog.iremember.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// vorläufig
		PersonDAO personDAO = new PersonDAO();
		Person person = new Person();
		person.setFirstName("Nicolas");
		person.setLastName("Wiedel");
		
		Calendar cal = Calendar.getInstance();
		cal.set(1966, Calendar.JUNE, 6);
		Date birthDate = new Date(cal.getTime().getTime());
		person.setBirthDate(birthDate);
		
		person.setStreet("Schwarzwaldstrasse");
		person.setHouseNumber("59");
		person.setCountry("D");
		person.setPostCode("74109");
		person.setTown("Freiburg");
		person.setPhone("0761/13456");
		person.setMobilePhone("0177/123456");
		person.setMail("mail@gmail.com");
		
		personDAO.persist(person);
		personDAO.shutdown();
		
		// 
		ViewFactory viewFactory = new ViewFactory();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
