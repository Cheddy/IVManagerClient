package com.csoftware.ivmanager.model.forms;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.csoftware.ivmanager.data.Constants;

public abstract class AbstractForm<T> extends Stage {
	private boolean goodExit = true;
	protected VBox listStage = new VBox();
	private VBox box = new VBox(2);
	private Button btnSaveButton;
	public T original;
	
	public AbstractForm(T object) {
		original = object;
		setTitle(Constants.PROGRAM_NAME + " - " + this.getClass().getSimpleName().replace("Form", "") + " Form");
		btnSaveButton = new Button("Save");
		btnSaveButton.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					hide();
				}
			}
		});
		btnSaveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				hide();
			}
		});
		setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			public void handle(WindowEvent e) {
				AbstractForm.this.goodExit = false;
			}
		});
		setScene(new Scene(box));
	}
	
	public T showForm() {
		fillListStage();
		box.getChildren().add(listStage);
		box.getChildren().add(btnSaveButton);
		showAndWait();
		if (goodExit)
			return getObject();
		else
			return original;
	}
	
	public abstract T getObject();
	
	public abstract void fillListStage();
	
}
