package app;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class StoryTwoGui {
	
	public void start(Stage arg0){
		Group root = new Group();
		Canvas canvas = new Canvas();
		root.getChildren().add(canvas);
		Scene scene = new Scene(root,650,500);
		arg0.setScene(scene);
		arg0.setTitle("Story Two");
		arg0.show();
	}
}
