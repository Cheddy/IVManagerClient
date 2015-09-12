package com.csoftware.ivmanager.model.forms.impl;

import com.csoftware.ivmanager.gui.components.DateTimeField;
import com.csoftware.ivmanager.model.InterventionAction;
import com.csoftware.ivmanager.model.forms.AbstractForm;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.joda.time.DateTime;

public class InterventionActionForm extends AbstractForm<InterventionAction> {

	private TextField descriptionField;
	private TextArea detailField;
	private DateTimeField dateTimeField;

	public InterventionActionForm(InterventionAction object) {
		super(object);
	}

	@Override
	public InterventionAction getObject() {
		if(original == null){
			original = new InterventionAction();
		}
		original.setDescription(descriptionField.getText());
		original.setDetail(detailField.getText());
		original.setDateTime(dateTimeField.getDate());
		return original;
	}

	@Override
	public void fillListStage() {
		Label descriptionLabel = new Label("Description: ");
		descriptionField = new TextField(original != null? original.getDescription():"");
		listStage.getChildren().addAll(descriptionLabel,descriptionField);	
	
		Label dateTimeLabel = new Label("Date/Time: ");
		dateTimeField = new DateTimeField(original != null? original.getDateTime():DateTime.now());
		listStage.getChildren().addAll(dateTimeLabel,dateTimeField);	
	
		Label detailLabel = new Label("Detail: ");
		detailField = new TextArea(original != null? original.getDetail():"");
		listStage.getChildren().addAll(detailLabel,detailField);	
	}
	
}
