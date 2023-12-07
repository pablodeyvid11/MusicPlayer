package mpb.gui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.directory.InvalidAttributesException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mpb.entities.User;
import mpb.entities.enums.UserType;
import mpb.gui.admin.Page;
import mpb.gui.util.Alerts;

public class ViewControllerSignUp implements Initializable {

	private Page page;

	public static Stage popupStage;

	@FXML
	private Label warning;

	@FXML
	private TextField nameSignUp;

	@FXML
	private TextField emailSignUp;

	@FXML
	private TextField passwordSignUp;

	@FXML
	private TextField confirmPasswordSignUp;

	@FXML
	private CheckBox vip;

	@FXML
	private Button signUpButton;

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		page = Page.createPage(null);
		this.warning.setText("");
	}

	public Page getPage() {
		return page;
	}

	@FXML
	public void onClickSignUp() {
		try {
			validate();

			User user = new User();

			user.setName(nameSignUp.getText());
			user.setEmail(emailSignUp.getText());
			user.setPassword(passwordSignUp.getText());

			user.setUserType(vip.isSelected() ? UserType.VIP : UserType.NORMAL);

			page.getUserService().persist(user);

			popupStage.close();

			Alerts.showAlert("Sucesso!", "Usuário criado com sucesso!", null, AlertType.INFORMATION);

		} catch (Exception e) {
			warning.setText(e.getMessage());
		}
	}

	private void validate() throws InvalidAttributesException {

		if (nameSignUp.getText().length() == 0) {
			throw new InvalidAttributesException("Nome não pode ser vazio");
		}

		Matcher m = Pattern.compile("^\\S+@\\w+(\\.\\w+)+$").matcher(emailSignUp.getText());

		if (!m.find()) {
			throw new InvalidAttributesException("Email inválido");
		}

		if (passwordSignUp.getText().length() < 5) {
			throw new InvalidAttributesException("Senha necessita ser maior que 5 caracteres");
		}

		if (!confirmPasswordSignUp.getText().equals(passwordSignUp.getText())) {
			throw new InvalidAttributesException("As senhas não são iguais");
		}
	}
}
