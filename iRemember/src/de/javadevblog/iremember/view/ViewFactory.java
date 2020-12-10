package de.javadevblog.iremember.view;

import de.javadevblog.iremember.controller.AdressViewController;
import de.javadevblog.iremember.controller.BaseController;
import de.javadevblog.iremember.controller.MailViewController;
import de.javadevblog.iremember.controller.MeetingViewController;
import de.javadevblog.iremember.controller.NoteViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewFactory {

	private Stage stage;
	private String stageTitle;
	private Scene scene;
	private BaseController baseController;
	private BaseController controller;
	private double sceneWidth;
	private double sceneHeight;
	
	public ViewFactory() {
		stage = new Stage();
		baseController = new BaseController(this, "baseview.fxml");
		sceneWidth = 900;
		sceneHeight = 600;
		showAdressView();
		stage.show();
	}

	public void showNoteView() {
		controller = new NoteViewController(this, "noteview.fxml");
		stage.setTitle("Notizen");
		initializeScene(controller);
	}
	
	public void showAdressView() {
		controller = new AdressViewController(this, "adressview.fxml");
		stage.setTitle("Adressen");
		initializeScene(controller);
	}
	
	public void showMailView() {
		controller = new MailViewController(this, "mailview.fxml");
		stage.setTitle("Email");
		initializeScene(controller);
	}
	
	public void showMeetingView() {
		controller = new MeetingViewController(this, "meetingview.fxml");
		stage.setTitle("Termine");
		initializeScene(controller);
	}

	private void initializeScene(BaseController controller) {
		FXMLLoader baseLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
		FXMLLoader loader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
		baseLoader.setController(baseController);
		loader.setController(controller);
		BorderPane mainPane;
		Parent parent;
		try {
			mainPane = baseLoader.load();
			parent = loader.load();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		mainPane.setCenter(parent);
		setSceneSice();
		scene = new Scene(mainPane, sceneWidth, sceneHeight);
		
		stage.setScene(scene);
	}

	private void setSceneSice() {
		if (scene != null) {
			sceneWidth = scene.getWidth();
			sceneHeight = scene.getHeight();
		}
		else {
			return;
		}
	}
}
