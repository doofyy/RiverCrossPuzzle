package app;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class StoryOneGui {
	@FXML Canvas canvas;
	public void start(Stage arg0) throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("StoryOne.fxml"));
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.fillRect(100, 100, 50, 50);
		Scene scene = new Scene(root,1280,720);
		arg0.setScene(scene);
		arg0.setTitle("Story One");
		arg0.show();
	}

}
