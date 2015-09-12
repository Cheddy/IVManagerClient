package com.csoftware.ivmanager.model.forms.impl;

import com.csoftware.ivmanager.model.Hospital;
import com.csoftware.ivmanager.model.forms.AbstractForm;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HospitalForm extends AbstractForm<Hospital> {

	private TextField nameField;

	public HospitalForm(Hospital object) {
		super(object);
	}

	@Override
	public Hospital getObject() {
		if(original == null){
			original = new Hospital();
		}
		original.setName(nameField.getText());
		return original;
	}

	@Override
	public void fillListStage() {
		Label nameLabel = new Label("Name: ");
		nameField = new TextField(original != null? original.getName():"");
		listStage.getChildren().addAll(nameLabel,nameField);	
	}
	
}
