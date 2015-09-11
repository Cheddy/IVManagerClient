package com.csoftware.ivmanager.model.managers;

import com.csoftware.ivmanager.data.Constants;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class AbstractManager<T> extends Stage {
	protected VBox listStage = new VBox();
	private VBox box = new VBox(2);
	private Button btnSaveButton, btnNewButton, btnEditButton, btnDeleteButton;
	public T[] original;

	public AbstractManager(T[] objects) {
		original = objects;
		setWidth(Constants.WINDOW_BOUNDS.getWidth());
		setHeight(Constants.WINDOW_BOUNDS.getHeight());
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
		btnNewButton = new Button("New");
		btnNewButton.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					newObject();
				}
			}
		});
		btnNewButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				newObject();
			}
		});
		
		btnEditButton = new Button("Edit");
		btnEditButton.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					editObject();
				}
			}
		});
		btnEditButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				editObject();
			}
		});
		
		btnDeleteButton = new Button("Delete");
		btnDeleteButton.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.ENTER) {
					deleteObject();
				}
			}
		});
		btnDeleteButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				deleteObject();
			}
		});
		box.setSpacing(10);
		setScene(new Scene(box));
	}
	
	public T[] showForm() {
		fillListStage();
		box.getChildren().add(listStage);
		HBox buttonBox = new HBox();
		buttonBox.getChildren().add(btnSaveButton);
		if ((Constants.userPermissions & getNewPermission()) != 0)
			buttonBox.getChildren().add(btnNewButton);
		if ((Constants.userPermissions & getEditPermission()) != 0)
			buttonBox.getChildren().add(btnEditButton);
		if ((Constants.userPermissions & getDeletePermission()) != 0)
			buttonBox.getChildren().add(btnDeleteButton);
		box.getChildren().add(buttonBox);
		VBox.setVgrow(listStage, Priority.ALWAYS);
		VBox.setVgrow(buttonBox, Priority.NEVER);
		showAndWait();
			return getObjects();
	}
	
	public abstract int getNewPermission();
	
	public abstract int getEditPermission();
	
	public abstract int getDeletePermission();
	
	public abstract T[] getObjects();
	
	public abstract void deleteObject();
	
	public abstract void editObject();
	
	public abstract void newObject();
	
	public abstract void onAdd(T object);
	
	public abstract void onEdit(T object);

	public abstract void onDelete(T object);
	
	public abstract void fillListStage();
	
}
