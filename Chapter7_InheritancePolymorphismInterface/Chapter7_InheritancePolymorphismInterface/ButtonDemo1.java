import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

/**
Simple demonstration of programming buttons in a JavaFX application.
This version outputs a message when clicked.
*/
public class ButtonDemo1 extends Application
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

	  // Create an event object to handle the button click.
	  // The "handle" method in HandleButtonClick will be
	  // invoked when the button is clicked.
	  HandleButtonClick clickEvent = new HandleButtonClick();
	  btnSunny.setOnAction(clickEvent);

	  // We can also create the HandleButtonClick object without
	  // a named reference by creating it inside the call to setOnAction
	  btnCloudy.setOnAction(new HandleButtonClick("It is cloudy."));

	  root.getChildren().add(btnSunny);
	  root.getChildren().add(btnCloudy);

   	  Scene scene = new Scene(root, 300, 100);
      primaryStage.setTitle("Button Event Handling Demo");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
