package com.csoftware.ivmanager.model.forms.impl;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import com.csoftware.ivmanager.model.Impact;
import com.csoftware.ivmanager.model.forms.AbstractForm;

public class ImpactForm extends AbstractForm<Impact> {

	private TextField nameField;

	public ImpactForm(Impact object) {
		super(object);
	}

	@Override
	public Impact getObject() {
		if(original == null){
			original = new Impact();
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
