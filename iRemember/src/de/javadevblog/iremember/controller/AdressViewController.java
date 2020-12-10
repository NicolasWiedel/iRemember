package de.javadevblog.iremember.controller;

import de.javadevblog.iremember.model.adresses.Person;
import de.javadevblog.iremember.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdressViewController extends BaseController {
	
	@FXML
	private TableView<Person> tableView;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	public AdressViewController(ViewFactory viewfactory, String fxmlName) {
		super(viewfactory, fxmlName);
		// TODO Auto-generated constructor stub
	}

}
