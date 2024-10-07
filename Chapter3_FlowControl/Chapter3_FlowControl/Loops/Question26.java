import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Question26 extends Application
{
	public static final int DIAMETER = 30;
	public static final int X_CENTER = 100;
	public static final int Y_CENTER = 100;
	public static final int GAP = 100;
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Group root = new Group();
		Scene scene = new Scene(root);
		Canvas canvas = new Canvas(800, 200);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		int radius = DIAMETER / 2;
		int x = X_CENTER - radius; // upper left corner
		int y = Y_CENTER - radius;
		for (int i = 1; i <= 6; i++)
		{
			gc.setFill(Color.BLUE);
			gc.fillOval(x, y, DIAMETER, DIAMETER);
			gc.setFill(Color.BLACK);
			gc.strokeOval(x, y, DIAMETER, DIAMETER);
			x += DIAMETER + GAP;
		}
		root.getChildren().add(canvas);
		primaryStage.setTitle("Circles in JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}