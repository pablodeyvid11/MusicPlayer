package mpb.gui.admin;

import java.io.IOException;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import mpb.gui.util.Alerts;
import mpb.services.UserService;

public class Page {

	private static Page page;

	private Stage mainStage;

	private static Scene playerFrame;
	private static Scene loginFrame;

	private UserService userService;

	private Page(Stage primaryStage) {
		if (primaryStage != null) {
			this.mainStage = primaryStage;
		}
		userService = new UserService();
	}

	public static Page createPage(Stage primaryStage) {
		if (page == null && primaryStage != null) {
			page = new Page(primaryStage);
		}
		return page;
	}

	public Stage getMainStage() {
		return mainStage;
	}

	public UserService getUserService() {
		return userService;
	}

	public void load() {
		try {
			mainStage.setResizable(false);
			loadLoginPage();
			loadPlayerPage();
			if(userService.getUserLogged() == null) {
				loginMainStage();
			} else {
				playerMainStage();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loginMainStage() throws IOException {
		mainStage.setScene(loginFrame);
		mainStage.setTitle("Login");
		mainStage.show();
	}
	
	private void playerMainStage() throws IOException {
		mainStage.setScene(playerFrame);
		mainStage.setTitle("Player");
		mainStage.show();
	}

	public void loadPlayerPage() throws IOException {
		Parent parentMainFrame = FXMLLoader.load(getClass().getResource("../PlayerView.fxml"));

		playerFrame = new Scene(parentMainFrame);
		playerFrame.getStylesheets().add(getClass().getResource("../styles/player.css").toExternalForm());
	}

	public void loadLoginPage() throws IOException {
		Parent parentMainFrame = FXMLLoader.load(getClass().getResource("../LoginView.fxml"));

		loginFrame = new Scene(parentMainFrame);
		loginFrame.getStylesheets().add(getClass().getResource("../styles/login.css").toExternalForm());
	}
	
	public void switchToPlayer() {
		mainStage.setScene(playerFrame);
		mainStage.setTitle("Player");
	}
 
	public void close(boolean mandatory) {
		int choice = 0;
		if (mandatory) {
			choice = 1;
		} else {
			choice = Alerts.showAlert("Confirmação", "Tem certeza que deseja sair? ",
					"Pressione OK para sair, caso queira continuar nessa tela, pressione Cancell ou feche essa notificação",
					AlertType.CONFIRMATION);
		}
		if (choice == 1) {
			if (mainStage.getScene().equals(playerFrame)) {
				Platform.exit();
				System.exit(0);
			}
		}
	}
}
