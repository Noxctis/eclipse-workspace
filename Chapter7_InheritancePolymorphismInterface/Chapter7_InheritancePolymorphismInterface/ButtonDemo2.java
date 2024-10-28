import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
Demonstration of event handling within the ButtonDemo2 class.
*/
public class ButtonDemo2 extends Application implements EventHandler<ActionEvent>
{
   private Button btnSunny;
   private Button btnCloudy;

   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void handle(ActionEvent event)
   {
	   // This method can access the member variables
	   // which reference the other GUI controls
	   if (event.getSource() instanceof Button)
	   {
		  Button btnClicked = (Button) event.getSource();
       	  if (btnClicked.getText().equals("Sunny"))
       	  {
			  // Disable the cloudy button if sunny clicked
			  btnCloudy.setDisable(true);
		  }
       	  else if (btnClicked.getText().equals("Cloudy"))
       	  {
			  // Disable the sunny button if cloudy clicked
			  btnSunny.setDisable(true);
		  }
	  }
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	  VBox root = new VBox();
	  btnSunny = new Button("Sunny");
	  btnCloudy = new Button("Cloudy");

	  btnSunny.setOnAction(this);
	  btnCloudy.setOnAction(this);

	  root.getChildren().add(btnSunny);
	  root.getChildren().add(btnCloudy);

   	  Scene scene = new Scene(root, 300, 100);
      primaryStage.setTitle("Button Demo 2");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
