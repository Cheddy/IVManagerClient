package com.csoftware.ivmanager.model.forms.impl;

import com.csoftware.ivmanager.model.InterventionDetail;
import com.csoftware.ivmanager.model.forms.AbstractForm;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InterventionDetailForm extends AbstractForm<InterventionDetail> {

	private TextField descriptionField;
	private TextArea detailField;

	public InterventionDetailForm(InterventionDetail object) {
		super(object);
	}

	@Override
	public InterventionDetail getObject() {
		if(original == null){
			original = new InterventionDetail();
		}
		original.setDescription(descriptionField.getText());
		original.setDetail(detailField.getText());
		return original;
	}

	@Override
	public void fillListStage() {
		Label descriptionLabel = new Label("Description: ");
		descriptionField = new TextField(original != null? original.getDescription():"");
		listStage.getChildren().addAll(descriptionLabel,descriptionField);	

		Label detailLabel = new Label("Detail: ");
		detailField = new TextArea(original != null? original.getDetail():"");
		listStage.getChildren().addAll(detailLabel,detailField);	
	}
	
}
