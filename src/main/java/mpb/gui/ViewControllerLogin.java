package mpb.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.directory.InvalidAttributesException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mpb.gui.admin.Page;

public class ViewControllerLogin implements Initializable {

	private Page page;

	@FXML
	public Button loginButton;

	@FXML
	private TextField email;

	@FXML
	private TextField password;

	@FXML
	private Hyperlink signUp;

	@FXML
	private Label warning;

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		page = Page.createPage(null);
		warning.setText("");
	}

	public Page getPage() {
		return page;
	}

	@FXML
	public void onClickLoginButton() {
		try {
			validate();
			page.getUserService().login(email.getText(), password.getText());
			page.switchToPlayer();
		} catch (Exception e) {
			warning.setText(e.getMessage());
		}
	}

	private void validate() throws InvalidAttributesException {

		Matcher m = Pattern.compile("^\\S+@\\w+(\\.\\w+)+$").matcher(email.getText());

		if (!m.find()) {
			throw new InvalidAttributesException("Email inválido");
		}
	}

	@FXML
	public void onClickSignUp() {
		try {
			signUpModal();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void closeButton() {
		page.close(false);
	}

	private void signUpModal() {
		Stage parentStage = page.getMainStage();

		Stage popupStage = new Stage();
		popupStage.initModality(Modality.WINDOW_MODAL);
		popupStage.initOwner(parentStage);
		popupStage.setResizable(false);

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("./signUpPopup.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root);

			popupStage.setScene(scene);
			scene.getStylesheets().add(getClass().getResource("./styles/signUpModal.css").toExternalForm());
			ViewControllerSignUp.popupStage = popupStage;
			popupStage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
