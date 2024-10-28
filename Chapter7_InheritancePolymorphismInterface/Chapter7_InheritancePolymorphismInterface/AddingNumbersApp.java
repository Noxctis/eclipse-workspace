import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
This application embeds a GridPane in the center of a
BorderPane. It allows the user to enter numbers into text fields
which are added together in the button click event. The sum is
displayed in a label in the bottom region of the BorderPane.
*/
public class AddingNumbersApp extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	  BorderPane root = new BorderPane();
	  // Margin of 10 pixels
	  root.setPadding(new Insets(10,10,10,10));

        Button btnAdd;
        TextField txtNum1, txtNum2;
        Label lblSum;

	  // Add a label message in the top. We create the
	  // label without a named reference since the label
	  // is read-only; we never change it so no reference is needed.
	  root.setTop(new Label("Enter an integer into each textbox " +
	  		"and click the button to compute the sum."));

	  // The label that will display the sum goes into the bottom.
	  // Initially it is just a blank string.
	  lblSum = new Label("");
	  root.setBottom(lblSum);

	  // Create a GridPane in the center of the BorderPane
	  GridPane center = new GridPane();
	  center.setVgap(5);
	  center.setHgap(5);
	  txtNum1 = new TextField("0"); // Default text of 0
	  txtNum1.setPrefWidth(150);
	  txtNum2 = new TextField("0");
	  txtNum2.setPrefWidth(150);
	  center.add(new Label("Number 1"), 0, 0);
	  center.add(new Label("Number 2"), 0, 1);
	  center.add(txtNum1, 1, 0);
	  center.add(txtNum2, 1, 1);
	  btnAdd = new Button("Add Numbers");
	  center.add(btnAdd, 1, 2);
	  root.setCenter(center);

	  // Set the event handler when the button is clicked
	  btnAdd.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		int num1 = Integer.parseInt(txtNum1.getText());
	   		int num2 = Integer.parseInt(txtNum2.getText());
	   		int sum = num1 + num2;
	   		lblSum.setText("The sum is " + sum);
	   	}
	   }
	  );

   	  Scene scene = new Scene(root, 450, 150);
      primaryStage.setTitle("Compute the Sum");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}

