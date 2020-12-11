package de.javadevblog.iremember.controller;

import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.ResourceBundle;

import de.javadevblog.iremember.model.adresses.Person;
import de.javadevblog.iremember.model.adresses.PersonDAO;
import de.javadevblog.iremember.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdressViewController extends BaseController implements Initializable {

	@FXML
	private TextField textFieldFirstName;
	@FXML
	private TextField textFieldLastName;
	@FXML
	private TextField textfFiedStreet;
	@FXML
	private TextField textFieldHouseumber;
	@FXML
	private TextField textFieldPlz;
	@FXML
	private TextField textFieldTown;
	@FXML
	private TextField textFieldPhone;
	@FXML
	private TextField textFieldMobilePhone;
	@FXML
	private TextField textFieldMail;
	@FXML
	private DatePicker datePickerBithday;
	@FXML
	private Button btnSave;
	@FXML
	private Button btnNew;
	@FXML
	private Button btnDelete;
	@FXML
	private TableView<Person> tableView;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	private ObservableList<Person> personData;
	
	// vorl�ufig
	private Person person;

	public AdressViewController(ViewFactory viewfactory, String fxmlName) {
		super(viewfactory, fxmlName);

		personData = FXCollections.observableArrayList();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));

		tableView.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showDetails(newValue));

		// vorl�ufig
		PersonDAO personDAO = new PersonDAO();
		person = new Person();
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

		personData.add(person);
		// bis hier vorl�ufig
		
		tableView.setItems(personData);

	}

	@FXML
	void btnNewAction(ActionEvent event) {

	}

	@FXML
	void btnDeleteAction(ActionEvent event) {

	}

	@FXML
	void btnSaveAction(ActionEvent event) {

	}
	
	private void showDetails(Person person){
		textFieldFirstName.setText(person.getFirstName());
		textFieldLastName.setText(person.getLastName());
		textfFiedStreet.setText(person.getStreet());
		textFieldHouseumber.setText(person.getHouseNumber());
		textFieldPlz.setText(person.getPostCode());
		textFieldTown.setText(person.getTown());
	}

}
