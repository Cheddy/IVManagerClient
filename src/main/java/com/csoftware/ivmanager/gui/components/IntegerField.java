package com.csoftware.ivmanager.gui.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class IntegerField extends TextField {

	public IntegerField(int rtx) {
		lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				setText(getText().replaceAll("[^0-9]", ""));
				if (getText().length() > 0) {
					if (new BigInteger(getText()).compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) {
						setText(String.valueOf(Integer.MAX_VALUE));
					}
				}
			}
		});
		setText(String.valueOf(rtx));
	}

	public long getLong() {
		if (getText() != null && !getText().equals("")) {
			return Long.parseLong(getText());
		}
		return 0;
	}
	
	public int getInt() {
		if (getText() != null && !getText().equals("")) {
			return Integer.parseInt(getText());
		}
		return 0;
	}

}
