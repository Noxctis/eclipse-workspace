import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.effect.Reflection;

public class ImageExample extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	Group root = new Group();
   	Scene scene = new Scene(root);

	// Java looks for "java.jpg" in the default folder
	Image img = new Image("java.jpg");
    Canvas canvas = new Canvas(400, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    // Draw image in normal scaling at (1,1)
    gc.drawImage(img, 1, 1);
    // Draw image twice as large to the right of
    // previous image
    gc.drawImage(img, img.getWidth() + 10, 1,
        		 img.getWidth() * 2, img.getHeight() * 2);
   	// Draw image below the first with a reflection effect
    gc.setEffect(new Reflection());
    gc.drawImage(img, 1, img.getHeight() *2);

    root.getChildren().add(canvas);
    primaryStage.setTitle("Drawing Images in JavaFX");
    primaryStage.setScene(scene);
    primaryStage.show();
   }
}
