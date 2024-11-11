import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;


/**
This program sets the X/Y coordinates of a Circle to the
location of the mouse.
*/
public class MouseCircle extends Application
{
   public static void main(String[] args)
   {
      Application.launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
      Pane root = new Pane();
      root.setPrefSize(400,400);

      Circle circle = new Circle();
      circle.setRadius(30);
      circle.setFill(Color.RED);

	  root.setOnMouseMoved(new EventHandler<MouseEvent>()
	  {
       	@Override
       	public void handle(MouseEvent event)
       	{
        	circle.setCenterX(event.getX());
        	circle.setCenterY(event.getY());
      	}
      });

      root.getChildren().add(circle);
      primaryStage.setScene(new Scene(root));
      primaryStage.setTitle("Mouse Circle");
      primaryStage.show();
   }
}