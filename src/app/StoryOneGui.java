package app;

import java.io.File;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class StoryOneGui {

	public void start(Stage arg0){
		Group root = new Group();
		Canvas canvas = new Canvas(1280,720); 
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.fillRect(100, 100, 60, 60);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root,1280,720);
		arg0.setScene(scene);
		arg0.setTitle("Story One");
		arg0.show();
	}

}
