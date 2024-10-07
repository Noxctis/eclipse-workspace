import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
/**
Simple demonstration of drawing two letters on top of each other
using the StackPane layout.
*/
public class StackPaneDemo extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	  StackPane root = new StackPane();
	  Label label1 = new Label("o");
	  label1.setFont(Font.font("Courier New", 54));
	  Label label2 = new Label("c");
	  label2.setFont(Font.font("Courier New", 24));
	  root.getChildren().add(label1);
	  root.getChildren().add(label2);

   	  Scene scene = new Scene(root, 300, 100);
      primaryStage.setTitle("StackPane Demo");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
