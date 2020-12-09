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
		Person nici = new Person();
		nici.setFirstName("Nicolas");
		nici.setLastName("Wiedel");
		
		Calendar cal = Calendar.getInstance();
		cal.set(1966, Calendar.JUNE, 6);
		Date birthDate = new Date(cal.getTime().getTime());
		nici.setBirthDate(birthDate);
		
		personDAO.persist(nici);
		personDAO.shutdown();
		
		// 
		ViewFactory viewFactory = new ViewFactory();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
