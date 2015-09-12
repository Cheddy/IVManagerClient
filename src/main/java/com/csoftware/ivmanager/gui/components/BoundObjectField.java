package com.csoftware.ivmanager.gui.components;

import com.csoftware.ivmanager.gui.ManagerFrame;

public class BoundObjectField<T> extends javafx.scene.control.ComboBox<T> {
	
	Class<T> boundObjectClass;
	
	public BoundObjectField(Class<T> boundObjectClass, T currentObject) {
		this.boundObjectClass = boundObjectClass;
		if (currentObject != null) {
			getItems().add(currentObject);
			getSelectionModel().select(currentObject);
		}
		ManagerFrame.netTransfer.loadComboBox(this, boundObjectClass);
	}
	
	public boolean isValid() {
		return !getSelectionModel().isEmpty();
	}
	
}
