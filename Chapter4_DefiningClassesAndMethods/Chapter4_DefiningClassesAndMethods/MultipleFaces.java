import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MultipleFaces extends Application
{
   public static final int WINDOW_WIDTH = 450;
   public static final int WINDOW_HEIGHT = 300;

   public static final int FACE_DIAMETER = 50;
   public static final int X_FACE0 = 10;
   public static final int Y_FACE0 = 5;

   public static final int EYE_WIDTH = 5;
   public static final int EYE_HEIGHT = 10;
   public static final int X_RIGHT_EYE0 = 20;
   public static final int Y_RIGHT_EYE0 = 15;
   public static final int X_LEFT_EYE0 = 45;
   public static final int Y_LEFT_EYE0 = Y_RIGHT_EYE0;

   public static final int NOSE_DIAMETER = 5;
   public static final int X_NOSE0 = 32;
   public static final int Y_NOSE0 = 25;

   public static final int MOUTH_WIDTH = 30;
   public static final int MOUTH_HEIGHT0 = 0;
   public static final int X_MOUTH0 = 20;
   public static final int Y_MOUTH0 = 35;
   public static final int MOUTH_START_ANGLE = 180;
   public static final int MOUTH_EXTENT_ANGLE = 180;

   public static void main(String[] args)
   {
      launch(args);
   }

   /**
   gc is the drawing area. pos indicates the position of the
   face. As pos increases, the face is drawn lower and further
   to the right.
   */
   private void drawFaceSansMouth(GraphicsContext gc, int pos)
   {
	   // Draw face oval
	   gc.setFill(Color.BLACK);
	   gc.strokeOval(X_FACE0 + 50 * pos, Y_FACE0 + 30 * pos,
	   		 	 FACE_DIAMETER, FACE_DIAMETER);
	   // Draw eyes
	   gc.setFill(Color.BLUE);
	   gc.fillOval(X_RIGHT_EYE0 + 50 * pos, Y_RIGHT_EYE0 + 30 * pos,
				   EYE_WIDTH, EYE_HEIGHT);
	   gc.fillOval(X_LEFT_EYE0 + 50 * pos, Y_LEFT_EYE0 + 30 * pos,
			   EYE_WIDTH, EYE_HEIGHT);
	   //Draw nose
	   gc.setFill(Color.BLACK);
	   gc.fillOval(X_NOSE0 + 50 * pos, Y_NOSE0 + 30 * pos,
			   NOSE_DIAMETER, NOSE_DIAMETER);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	  Group root = new Group();
   	  Scene scene = new Scene(root);

        Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

	  int i;   //Want i to exist after the loop ends

	  for (i = 0; i <= 4; i++)
  	  {//Draw one face:
		  if (i % 2 == 0)//if i is even
		  {//Make face yellow
		  	gc.setFill(Color.YELLOW);
			gc.fillOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i,
							FACE_DIAMETER, FACE_DIAMETER);
		  }
		  drawFaceSansMouth(gc, i);
		  //Draw mouth:
		  gc.setFill(Color.RED);
		  gc.strokeArc(X_MOUTH0 + 50 * i, Y_MOUTH0 + 30 * i,
					   MOUTH_WIDTH, MOUTH_HEIGHT0 + 3 * i + 1,
					   MOUTH_START_ANGLE, MOUTH_EXTENT_ANGLE,
					   ArcType.OPEN);
	  }
	  //i is 5 when the previous loop ends

	  //Draw kissing face:
	  drawFaceSansMouth(gc, i);
	  //Draw mouth in shape of a kiss:
	  gc.setFill(Color.RED);
	  gc.fillOval(X_MOUTH0 + 50 * i + 10, Y_MOUTH0 + 30 * i,
					MOUTH_WIDTH - 20, MOUTH_WIDTH - 20);
	  //Add text in Times New Roman, 12 point:
	  gc.setFont(Font.font("Times New Roman", 12));
	  gc.setFill(Color.BLACK);
	  gc.fillText("Kiss, Kiss.",
			X_FACE0 + 50 * i + FACE_DIAMETER, Y_FACE0 + 30 * i);

	  //Draw blushing face:
	  i++;
	  //Draw face circle:
	  gc.setFill(Color.PINK);
	  gc.fillOval(X_FACE0 + 50*i, Y_FACE0 + 30*i,
	  			FACE_DIAMETER, FACE_DIAMETER);
	  drawFaceSansMouth(gc, i);
	  gc.setFill(Color.RED);
	  //Draw mouth:
	  gc.setFill(Color.BLACK);
	  gc.strokeArc(X_MOUTH0 + 50*i, Y_MOUTH0 + 30*i, MOUTH_WIDTH,
			   MOUTH_HEIGHT0 + 3 * (i - 2),
			   MOUTH_START_ANGLE, MOUTH_EXTENT_ANGLE, ArcType.OPEN);
	  //Add text in Courier New Font, 16 point:
	  gc.setFont(Font.font("Courier New ", 16));
	  gc.fillText("Tee Hee.",
			  X_FACE0 + 50*i + FACE_DIAMETER, Y_FACE0 + 30*i);

      root.getChildren().add(canvas);
      primaryStage.setTitle("MultipleFaces in JavaFX");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
