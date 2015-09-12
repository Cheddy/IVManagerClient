package com.csoftware.ivmanager.model.forms.impl;

import com.csoftware.ivmanager.gui.components.IntegerField;
import com.csoftware.ivmanager.model.StaffRank;
import com.csoftware.ivmanager.model.forms.AbstractForm;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StaffRankForm extends AbstractForm<StaffRank> {

	private TextField nameField;
	private IntegerField permissionsField;

	public StaffRankForm(StaffRank object) {
		super(object);
	}

	@Override
	public StaffRank getObject() {
		if(original == null){
			original = new StaffRank();
		}
		original.setName(nameField.getText());
		original.setPermissions(permissionsField.getInt());
		return original;
	}

	@Override
	public void fillListStage() {
		Label nameLabel = new Label("Name: ");
		nameField = new TextField(original != null? original.getName():"");
		listStage.getChildren().addAll(nameLabel,nameField);	
		
		Label permissionsLabel = new Label("Permissions: ");
		permissionsField = new IntegerField(original != null? original.getPermissions():0);
		listStage.getChildren().addAll(permissionsLabel,permissionsField);	
	}
	
}
