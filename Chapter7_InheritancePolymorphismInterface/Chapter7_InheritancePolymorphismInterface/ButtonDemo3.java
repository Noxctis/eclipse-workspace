import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

/**
Event handling with an anonymous inner class.
*/
public class ButtonDemo3 extends Application
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
        Label lblMessage;
	  btnSunny = new Button("Sunny");
	  btnCloudy = new Button("Cloudy");
	  lblMessage = new Label("Click a button.");

	  // Create an anonymous inner class to handle btnSunny
	  btnSunny.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		lblMessage.setText("It is sunny!");
	   	}
	   }
	  );
	  // Create an anonymous inner class to handle btnCloudy
	  btnCloudy.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		lblMessage.setText("It is cloudy!");
	   	}
	   }
	  );

	  root.getChildren().add(btnSunny);
	  root.getChildren().add(btnCloudy);
	  root.getChildren().add(lblMessage);

   	  Scene scene = new Scene(root, 300, 100);
      primaryStage.setTitle("Button Demo 3");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
