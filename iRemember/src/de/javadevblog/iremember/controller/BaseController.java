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
	private Button btnMeetings;

	@FXML
	private Button btnNotes;

	public BaseController(ViewFactory viewFactory, String fxmlName) {
		this.viewFactory = viewFactory;
		this.fxmlName = fxmlName;
	}
	
	@FXML
	public void changeCategorie(ActionEvent e) {
		if ( e.getSource() == btnNotes) {
			System.out.println("Notizen gedr�ckt!");
			viewFactory.showNoteView();
		}else if ( e.getSource() == btnAdresses) {
			System.out.println("Adressen gedr�ckt!");
			viewFactory.showAdressView();
		}else if ( e.getSource() == btnMails) {
			System.out.println("Email gedr�ckt!");
			viewFactory.showMailView();
		}else if ( e.getSource() == btnMeetings) {
			System.out.println("Termine gedr�ckt!");
			viewFactory.showMeetingView();
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
