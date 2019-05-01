package app;

import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StoryOneGui {
	public void start(Stage arg0) throws IOException{
		Group root = new Group();
		Canvas canvas = new Canvas(1280,720); 
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.fillRect(0, 0, 1280, 720);
		root.getChildren().add(canvas);
		Scene scene = new Scene(root,1280,720);
		arg0.setScene(scene);
		arg0.setTitle("Story ONE");
		arg0.show();
	}

}
