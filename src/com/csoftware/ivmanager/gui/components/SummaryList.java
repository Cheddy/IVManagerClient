package com.csoftware.ivmanager.gui.components;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import com.csoftware.ivmanager.forms.ItemForm;
import com.csoftware.ivmanager.model.InterventionDetail;

public class SummaryList extends ListView<InterventionDetail> {

	InterventionDetail[] summary;

	public SummaryList(InterventionDetail[] summary) {
		setEditable(false);
		if (summary == null)
			summary = new InterventionDetail[0];
		this.summary = summary;
		setItems(FXCollections.observableArrayList(summary));
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (e.getClickCount() >= 2) {
					InterventionDetail item = getSelectionModel().getSelectedItem();
					if (item != null) {
						new ItemForm(item.getDescription(), item.getDetail(), null).getDetailItem();
						getSelectionModel().clearSelection();
					}
				}
			}
		});
	}

}
