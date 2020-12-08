package de.javadevblog.iremember.controller;

import de.javadevblog.iremember.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BaseController {

	protected ViewFactory viewFactory;
	private String fxmlName;

	@FXML
	private Button btnAdresses;

	@FXML
	private Button btnMails;

	@FXML
	private Button btnDates;

	@FXML
	private Button btnNotes;

	public BaseController(ViewFactory viewFactory, String fxmlName) {
		this.viewFactory = viewFactory;
		this.fxmlName = fxmlName;
	}
	
	@FXML
	public void changeCatgorie(ActionEvent e) {
		if ( e.getSource() == btnNotes) {
			System.out.println("Notizen gedrückt!");
		}
	}

	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public void setViewFactory(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}

	public String getFxmlName() {
		return fxmlName;
	}

	public void setFxmlName(String fxmlName) {
		this.fxmlName = fxmlName;
	}

}
