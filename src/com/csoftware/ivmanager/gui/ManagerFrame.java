package com.csoftware.ivmanager.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.UIManager;

import com.csoftware.ivmanager.data.Constants;
import com.csoftware.ivmanager.net.NetTransfer;

public class ManagerFrame extends Application {

	public static ManagerMenuBar menuBar;
	public static ManagerToolBar toolBar;
	public static ManagerTablePane tablePane;
	public static NetTransfer netTransfer;
	public static Stage stage;
	
	@Override
	public void start(Stage stage) throws Exception {
		ManagerFrame.stage = stage;
		initialiseGUIComponents();
		
		stage.setTitle(Constants.PROGRAM_NAME + " - v" + Constants.PROGRAM_VERSION);
		stage.getIcons().add(Constants.LOGO);
		final VBox rootGroup = new VBox();
		rootGroup.getChildren().addAll(ManagerFrame.menuBar);

		VBox.setVgrow(ManagerFrame.menuBar, Priority.NEVER);
//		VBox.setVgrow(ManagerFrame.toolBar, Priority.NEVER);
//		VBox.setVgrow(ManagerFrame.tablePane.getTable(), Priority.ALWAYS);
		stage.setScene(new Scene(rootGroup));
		stage.setMaximized(true);
		stage.setWidth(Constants.WINDOW_BOUNDS.getWidth());
		stage.setHeight(Constants.WINDOW_BOUNDS.getHeight());
		stage.setX(Constants.WINDOW_BOUNDS.getX());
		stage.setY(Constants.WINDOW_BOUNDS.getY());
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		netTransfer = new NetTransfer();
		Thread thread = new Thread(netTransfer);
		thread.setDaemon(true);
		thread.start();
		
		stage.show();
	}

	private void initialiseGUIComponents() {
		menuBar = new ManagerMenuBar();
//		toolBar = new ManagerToolBar();
//		tablePane = new ManagerTablePane();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
