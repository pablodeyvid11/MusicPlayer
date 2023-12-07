package mpb;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;
import mpb.gui.admin.Page;

public class Main extends Application {

	private Page page;

	public static void main(String[] args) throws SQLException {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		page = Page.createPage(primaryStage);
		page.load();
	}
}
