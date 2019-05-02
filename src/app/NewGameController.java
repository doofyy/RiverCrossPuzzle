package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class NewGameController implements Initializable {
	@FXML private ChoiceBox<String> choiceBox;
	@FXML public Button startButton;
	@FXML public Button backButton;
	ObservableList<String> level = FXCollections.observableArrayList("Story One","Story Two");
	
	public void back(ActionEvent event) throws IOException {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Scene scene = new Scene(root, 800, 500);
		window.setScene(scene);
		window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		choiceBox.setItems(level);
		choiceBox.setValue("Story One");
		
	}

	public void startNewGame(ActionEvent event) throws IOException {
        //opens story 1 gui
		if(choiceBox.getSelectionModel().getSelectedItem().equals("Story One")) {
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("Story1.fxml"));
			Scene scene = new Scene(root, 800, 600);
			window.setScene(scene);
			window.show();
		}
		else {
			System.out.println("opens story 2");
		}
	}
}
