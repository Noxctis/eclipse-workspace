import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

/**
Simple demonstration of adding buttons to a JavaFX application.
These buttons do not do anything. That comes in a later version.
*/
public class PreliminaryButtonDemo extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	  VBox root = new VBox();
      Button btnSunny;
      Button btnCloudy;
	  btnSunny = new Button("Sunny");
	  btnCloudy = new Button("Cloudy");
	  root.getChildren().add(btnSunny);
	  root.getChildren().add(btnCloudy);

   	  Scene scene = new Scene(root, 300, 100);
      primaryStage.setTitle("Button Demo");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
