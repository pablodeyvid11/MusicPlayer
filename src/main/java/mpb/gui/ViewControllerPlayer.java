package mpb.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import mpb.gui.admin.Page;

public class ViewControllerPlayer implements Initializable  {

	private Page page;
	
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		page = Page.createPage(null);
	}

	public Page getPage() {
		return page;
	}
	
	@FXML
	public void closeButton() {
		page.close(false);
	}
}
