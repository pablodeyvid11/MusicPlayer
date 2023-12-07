package mpb.gui.util;

import java.util.List;
import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alerts {

	public static int showAlert(String title, String header, String content, AlertType type) {
		Alert alert = new Alert(type);
		alert.setTitle(title);
		alert.setHeaderText(header);
		alert.setContentText(content);
		
		Optional<ButtonType> result = alert.showAndWait();

		try {
			if (result.get() == ButtonType.OK) {
				return 1;
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public static String showAlertTextField(String oldValue, String title, String header, String content,
			Boolean isNumber) throws Exception {
		TextInputDialog dialog = new TextInputDialog(oldValue);
		if (isNumber) {
			Rules.ruleTextJustWithNumbers(dialog.getEditor());
			Rules.ruleSizeMax(dialog.getEditor(), 12);
		}
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(content);

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new Exception("Error");
		}
	}

	public static String showAlertComboBox(List<String> choices, String title, String header, String content)
			throws Exception {

		ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
		dialog.setTitle(title);
		dialog.setHeaderText(header);
		dialog.setContentText(content);

		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new Exception("Error");
		}
	}
}