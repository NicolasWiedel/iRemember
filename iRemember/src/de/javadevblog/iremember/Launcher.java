package de.javadevblog.iremember;

import de.javadevblog.iremember.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {
	
	private ViewFactory viewFactory;

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		viewFactory = new ViewFactory();
	}
	
	@Override
	public void stop() throws Exception {
		super.stop();
		viewFactory.getDao().shutdown();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
