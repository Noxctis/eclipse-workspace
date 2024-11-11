import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.util.Random;

/**
This program draws a circle of random color
at the location of the mouse whenever the mouse
moves.
*/
public class MousePaint extends Application
{
   private Random rnd = new Random();

   public static void main(String[] args) {
      Application.launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception {

      Group root = new Group();
      Canvas canvas = new Canvas(650, 600);
      GraphicsContext gc = canvas.getGraphicsContext2D();

	  // When the mouse is pressed erase the
	  // screen by drawing a white rectangle on the
	  // entire canvas
	  canvas.setOnMousePressed(new EventHandler<MouseEvent>()
	  {
        @Override
        public void handle(MouseEvent event)
        {
      	  gc.setFill(Color.WHITE);
          gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        }
      });

	  // When the mouse is moved get a random color
	  // and draw a circle at the mouse's coordinates
	  canvas.setOnMouseMoved(new EventHandler<MouseEvent>()
	  {
         @Override public void handle(MouseEvent event)
         {
	       // Get a random color
           gc.setFill(Color.rgb(rnd.nextInt(255),
                rnd.nextInt(255),
                rnd.nextInt(255)));
           gc.fillOval(event.getX(),event.getY(),100,100);
         }
      });

      root.getChildren().add(canvas);
      primaryStage.setScene(new Scene(root));
      primaryStage.setTitle("Mouse Paint");
      primaryStage.show();
   }
}