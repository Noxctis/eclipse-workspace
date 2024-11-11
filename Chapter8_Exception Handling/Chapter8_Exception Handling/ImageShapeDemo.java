import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
Demonstration of some shapes and an image
within a VBox layout.
*/
public class ImageShapeDemo extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	VBox root = new VBox();
    ImageView imv = new ImageView();
    // Java looks for "java.jpg" in the default folder
    Image img = new Image("java.jpg");
    imv.setImage(img);

	Circle c = new Circle();
	c.setRadius(25);
	c.setFill(Color.PINK);

	Rectangle r = new Rectangle();
	r.setWidth(100);
	r.setHeight(50);
	r.setFill(Color.BLUE);

	root.getChildren().add(imv);
	root.getChildren().add(c);
	root.getChildren().add(r);


   	Scene scene = new Scene(root, 300, 200);
    primaryStage.setTitle("Image and Shape Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
   }
}
