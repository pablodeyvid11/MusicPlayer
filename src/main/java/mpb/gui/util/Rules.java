package mpb.gui.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Rules {
	public static void ruleTextJustWithNumbers(TextField txt) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && !newValue.matches("\\d*")) {
				txt.setText(oldValue);
			}
		});
	}

	public static void ruleEmailFormat(TextField txt, Label label) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			String email = txt.getText();
			Matcher m = Pattern.compile("^\\S+@\\w+(\\.\\w+)+$").matcher(email);
			if(m.find()) {
				label.setText("");
			} else {
				label.setText("*");
			}
		});
	}

	public static void ruleSizeMax(TextField txt, int max) {
		txt.textProperty().addListener((obs, oldValue, newValue) -> {
			if (newValue != null && newValue.length() > max) {
				txt.setText(oldValue);
			}
		});
	}
}
