package com.csoftware.ivmanager.gui.components;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DateTimeField extends TextField {

	final String mask = "00/00/0000 00:00";
	final Pattern pattern = Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d \\d\\d:\\d\\d");
	final int length = mask.length();
	ArrayList<Integer> maskIndices = new ArrayList<>();
	public static final char M = '0';

	public boolean overrideNext = true;

	public DateTimeField(DateTime start) {
		selectedTextProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				deselect();
			}
		});

		focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue && !verifyMask()) {
					setText(start.toString("dd/MM/yyyy HH:mm"));
				}
			}
		});
		setText(start.toString("dd/MM/yyyy HH:mm"));
		for (int i = 0; i < mask.length(); i++) {
			char c = mask.charAt(i);
			if (c != M) {
				maskIndices.add(i);
			}
		}
	}

	protected boolean verifyMask() {
		String inp = getText();
		if (!pattern.matcher(inp).matches()) {
			return false;
		}
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		    formatter.setLenient(false);
		    formatter.parse(inp);
			return true;
		} catch (ParseException nfe) {
			return false;
		}

		
		
	}

	@Override
	public void replaceText(int start, int end, String text) {
		if (end - start > 2 || start > length) {
			return;
		}

		if (text.length() > 0) { // Appending
			if (text.replaceAll("[^0-9]", "").length() < 1) {
				return;
			}
			end++;
			if (end > length) {
				return;
			}
			if (maskIndices.contains(start)) {
				start++;
				end++;
			}
		} else {
			if (end > length + 1) {
				return;
			}
			if (maskIndices.contains(start)) {
				end--;
				start--;
			}
			text = new String(new char[] {
				M
			});
		}

		super.replaceText(start, end, text);
	}

	@Override
	public void replaceSelection(String replacement) {
		return;
	}

	public DateTime getDate() {
	    return LocalDateTime.parse(getText(), DateTimeFormat.forPattern("dd/MM/yyyy HH:mm")).toDateTime();
	}

}
