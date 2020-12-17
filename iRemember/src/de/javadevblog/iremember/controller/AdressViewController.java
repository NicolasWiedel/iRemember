package de.javadevblog.iremember.controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

import de.javadevblog.iremember.model.adresses.Person;
import de.javadevblog.iremember.view.ViewFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
	private Person aktuellePerson;

	public AdressViewController(ViewFactory viewfactory, String fxmlName) {
		super(viewfactory, fxmlName);

		personData = FXCollections.observableArrayList();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
			@Override
			public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
				if(!personData.isEmpty()){
					showPersonInFields(newValue);
				}	
			}
		});

		personData = loadPersonsFromDatabase();

		tableView.setItems(personData);

	}

	private ObservableList<Person> loadPersonsFromDatabase() {
		return FXCollections.observableArrayList(viewFactory.getDao().findAll());
	}

	@FXML
	public void btnNewAction() {
		aktuellePerson = new Person();
		updateDatabaseFromFields();
		clearFields();
	}

	@FXML
	public void btnDeleteAction() {
		if(aktuellePerson != null) {
			viewFactory.getDao().delete(aktuellePerson);
			tableView.getItems().clear();
			tableView.setItems(loadPersonsFromDatabase());
		}
		else {
			// TODO: Fehlermeldung ausgeben!
		}
	}
	

	@FXML
	public void btnSaveAction() {
		updateDatabaseFromFields();
	}
	
	private void updateDatabaseFromFields() {
		aktuellePerson.setFirstName(textFieldFirstName.getText());
		aktuellePerson.setLastName(textFieldLastName.getText());
		aktuellePerson.setStreet(textfFiedStreet.getText());
		aktuellePerson.setHouseNumber(textFieldHouseumber.getText());
		aktuellePerson.setTown(textFieldTown.getText());
		aktuellePerson.setPhone(textFieldPhone.getText());
		aktuellePerson.setMobilePhone(textFieldMobilePhone.getText());
		aktuellePerson.setMail(textFieldMail.getText());
		
		if (datePickerBithday != null) {
			Date birthDate = Date.valueOf(datePickerBithday.getValue());
			aktuellePerson.setBirthDate(birthDate);
		}
		else {
			aktuellePerson.setBirthDate(null);
		}
		
		viewFactory.getDao().persist(aktuellePerson);
		personData.clear();
		personData = loadPersonsFromDatabase();
		tableView.setItems(personData);
	}

	private void showPersonInFields(Person aktuellePerson) {
		this.aktuellePerson = aktuellePerson;
		textFieldFirstName.setText(aktuellePerson.getFirstName());
		textFieldLastName.setText(aktuellePerson.getLastName());
		textfFiedStreet.setText(aktuellePerson.getStreet());
		textFieldHouseumber.setText(aktuellePerson.getHouseNumber());
		textFieldPlz.setText(aktuellePerson.getPostCode());
		textFieldTown.setText(aktuellePerson.getTown());
		textFieldPhone.setText(aktuellePerson.getPhone());
		textFieldMobilePhone.setText(aktuellePerson.getMobilePhone());
		textFieldMail.setText(aktuellePerson.getMail());
		
		if(aktuellePerson.getBirthDate() != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(aktuellePerson.getBirthDate());
			LocalDate date = LocalDate.of(cal.get(Calendar.YEAR), Calendar.MONTH, Calendar.DAY_OF_MONTH);
			datePickerBithday.setValue(date);
		}
		else {
			datePickerBithday.setValue(null);
		}
	}
	
	private void clearFields() {
		textFieldFirstName.setText("");
		textFieldLastName.setText("");
		textfFiedStreet.setText("");
		textFieldHouseumber.setText("");
		textFieldPlz.setText("");
		textFieldTown.setText("");
		textFieldPhone.setText("");
		textFieldMobilePhone.setText("");
		textFieldMail.setText("");
		datePickerBithday.setValue(null);
		aktuellePerson = null;
	}
}
