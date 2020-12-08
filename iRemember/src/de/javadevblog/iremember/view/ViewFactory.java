package de.javadevblog.iremember.view;

import de.javadevblog.iremember.controller.BaseController;
import de.javadevblog.iremember.controller.NoteViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewFactory {

	private Stage stage;
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
		showNoteScene();
		stage.show();
	}

	public void showNoteScene() {
		controller = new NoteViewController(this, "noteview.fxml");
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
