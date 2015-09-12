package com.csoftware.ivmanager.model.forms.impl;

import com.csoftware.ivmanager.gui.components.BoundObjectField;
import com.csoftware.ivmanager.model.CompleteWard;
import com.csoftware.ivmanager.model.Hospital;
import com.csoftware.ivmanager.model.forms.AbstractForm;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class WardForm extends AbstractForm<CompleteWard> {
	
	private TextField nameField;
	private BoundObjectField<Hospital> hospitalField;
	
	public WardForm(CompleteWard object) {
		super(object);
	}
	
	@Override
	public CompleteWard getObject() {
		if (original == null) {
			original = new CompleteWard();
		}
		original.setName(nameField.getText());
		original.setHospital(hospitalField.getSelectionModel().getSelectedItem());
		return original;
	}
	
	@Override
	public void fillListStage() {
		Label surnameLabel = new Label("Name: ");
		nameField = new TextField(original != null ? original.getName() : "");
		listStage.getChildren().addAll(surnameLabel, nameField);
		
		Label rankLabel = new Label("Hospital: ");
		hospitalField = new BoundObjectField<>(Hospital.class, original != null ? original.getHospital() : null);
		listStage.getChildren().addAll(rankLabel, hospitalField);
	}
	
}
