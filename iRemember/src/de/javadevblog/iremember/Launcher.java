package de.javadevblog.iremember;

import de.javadevblog.iremember.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		ViewFactory viewFactory = new ViewFactory();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
