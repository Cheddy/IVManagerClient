package com.csoftware.ivmanager.model.forms.impl;

import com.csoftware.ivmanager.gui.components.BoundObjectField;
import com.csoftware.ivmanager.model.CompleteStaff;
import com.csoftware.ivmanager.model.StaffRank;
import com.csoftware.ivmanager.model.forms.AbstractForm;
import com.csoftware.ivmanager.net.SHA1;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class StaffForm extends AbstractForm<CompleteStaff> {
	
	private TextField surnameField;
	private TextField otherNameField;
	private TextField usernameField;
	private PasswordField passwordField;
	private BoundObjectField<StaffRank> rankField;
	
	public StaffForm(CompleteStaff object) {
		super(object);
	}
	
	@Override
	public CompleteStaff getObject() {
		if (original == null) {
			original = new CompleteStaff();
		}
		original.setSurname(surnameField.getText());
		original.setOthernames(otherNameField.getText());
		original.setUsername(usernameField.getText());
		if (!passwordField.getText().isEmpty()){
			original.setPasswordHash(SHA1.hash(passwordField.getText()));
		}
		original.setRank(rankField.getSelectionModel().getSelectedItem());
		return original;
	}
	
	@Override
	public void fillListStage() {
		Label surnameLabel = new Label("Surname: ");
		surnameField = new TextField(original != null ? original.getSurname() : "");
		listStage.getChildren().addAll(surnameLabel, surnameField);
		
		Label otherNameLabel = new Label("Other Names: ");
		otherNameField = new TextField(original != null ? original.getOthernames() : "");
		listStage.getChildren().addAll(otherNameLabel, otherNameField);
		
		Label usernameLabel = new Label("Username: ");
		usernameField = new TextField(original != null ? original.getUsername() : "");
		listStage.getChildren().addAll(usernameLabel, usernameField);
		
		Label rankLabel = new Label("Rank: ");
		rankField = new BoundObjectField<>(StaffRank.class, original != null ? original.getRank() : null);
		listStage.getChildren().addAll(rankLabel, rankField);
		
		Label passwordLabel = new Label("Password (Leave Blank To Leave It Unedited): ");
		passwordField = new PasswordField();
		listStage.getChildren().addAll(passwordLabel, passwordField);
		
	}
	
}
