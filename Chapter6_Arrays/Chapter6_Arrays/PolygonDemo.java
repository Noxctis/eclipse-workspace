import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PolygonDemo extends Application
{
   private double[] xHouse = {150, 150, 200, 250, 250};
   private double[] yHouse = {100, 40, 20, 40, 100};
   private double[] xDoor = {175, 175, 200, 200};
   private double[] yDoor = {100, 60, 60, 100};
   private double[] xWindow = {220, 220, 240, 240};
   private double[] yWindow = {60, 80, 80, 60};

   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	  Group root = new Group();
   	  Scene scene = new Scene(root);

      Canvas canvas = new Canvas(400, 150);
      GraphicsContext gc = canvas.getGraphicsContext2D();

      gc.setFill(Color.GREEN);
      gc.fillPolygon(xHouse, yHouse, xHouse.length);
      gc.setFill(Color.BLACK);
      gc.strokePolyline(xDoor, yDoor, xDoor.length);
      gc.strokePolygon(xWindow, yWindow, xWindow.length);

      root.getChildren().add(canvas);
      primaryStage.setTitle("Home sweet home!");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
