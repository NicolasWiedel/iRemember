package de.javadevblog.iremember.view;

import de.javadevblog.iremember.DAO;
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

	private DAO dao;
	
	private Stage stage;
	private String stageTitle;
	private Scene scene;
	private BaseController baseController;
	private BaseController controller;
	private double sceneWidth;
	private double sceneHeight;
	private String title = "iRemember";
	
	public ViewFactory() {
		dao= new DAO();
		stage = new Stage();
		baseController = new BaseController(this, "baseview.fxml");
		sceneWidth = 900;
		sceneHeight = 600;
		showAdressView();
		stage.show();
	}

	public void showNoteView() {
		controller = new NoteViewController(this, "noteview.fxml");
		stage.setTitle(title + " - Notizen");
		initializeScene(controller);
	}
	
	public void showAdressView() {
		controller = new AdressViewController(this, "adressview.fxml");
		stage.setTitle(title + " - Adressen");
		initializeScene(controller);
	}
	
	public void showMailView() {
		controller = new MailViewController(this, "mailview.fxml");
		stage.setTitle(title + " - Email");
		initializeScene(controller);
	}
	
	public void showMeetingView() {
		controller = new MeetingViewController(this, "meetingview.fxml");
		stage.setTitle(title + " - Termine");
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

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	
}
