package com.csoftware.ivmanager.forms;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.joda.time.DateTime;

import com.csoftware.ivmanager.gui.components.DateTimeField;
import com.csoftware.ivmanager.model.InterventionAction;
import com.csoftware.ivmanager.model.InterventionDetail;
import com.csoftware.ivmanager.model.InterventionOutcome;

public class ItemForm extends Stage {

	private ComboBox<String> descField;
	private TextArea detailField;
	private DateTimeField datePicker;
	protected boolean goodExit = true;

	public ItemForm(String desc, String detail, DateTime date) {
		setTitle("Item Editor");

		if (desc == null) {
			desc = "";
		}
		if (detail == null) {
			detail = "";
		}

		VBox box = new VBox(10);

		descField = new ComboBox<String>();
		descField.setEditable(true);
		descField.setMaxWidth(Double.MAX_VALUE);
		descField.getSelectionModel().select(desc);
		box.getChildren().addAll(new Label("Description"), descField);

		if (date != null) {
			datePicker = new DateTimeField(date);
			box.getChildren().addAll(new Label("Date"), datePicker);
		}

		detailField = new TextArea(detail);
		box.getChildren().addAll(new Label("Detail"), detailField);

		Button btnSaveButton = new Button("Save");
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
		box.getChildren().add(btnSaveButton);
		setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				ItemForm.this.goodExit = false;
			}
		});

		setScene(new Scene(box));
		showAndWait();
	}

	public InterventionAction getActionItem() {
		if(!goodExit)
			return null;
		return new InterventionAction(descField.getSelectionModel().getSelectedItem(), detailField.getText(), datePicker.getDate());
	}
	
	public InterventionOutcome getOutcomeItem() {
		if(!goodExit)
			return null;
		return new InterventionOutcome(descField.getSelectionModel().getSelectedItem(), detailField.getText(), datePicker.getDate());
	}

	public InterventionDetail getDetailItem() {
		if(!goodExit)
			return null;
		return new InterventionDetail(descField.getSelectionModel().getSelectedItem(), detailField.getText());
	}

}
