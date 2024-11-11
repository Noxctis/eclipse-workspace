import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ChoiceBox;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
Simple demonstration of some additional JavaFX
UI controls.
*/
public class AdditionalControlsDemo extends Application
{
   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
	  VBox root = new VBox();

	  // Demonstrate radio buttons
	  root.getChildren().add(new Label("Select pizza crust"));
      ToggleGroup toggleCrust = new ToggleGroup();
      RadioButton rbHand = new RadioButton("Hand tossed");
      rbHand.setToggleGroup(toggleCrust);
      rbHand.setSelected(true);
      RadioButton rbDeepDish = new RadioButton("Deep dish");
      rbDeepDish.setToggleGroup(toggleCrust);
	  root.getChildren().add(rbHand);
	  root.getChildren().add(rbDeepDish);

	  // Demonstrate checkboxes
	  root.getChildren().add(new Label("Select pizza toppings"));
  	  CheckBox cbCheese = new CheckBox("Extra cheese");
	  CheckBox cbPepperoni = new CheckBox("Pepperoni");
	  CheckBox cbMushrooms = new CheckBox("Mushrooms");
	  root.getChildren().add(cbCheese);
	  root.getChildren().add(cbPepperoni);
	  root.getChildren().add(cbMushrooms);

	  // Demonstrate Spinner with integer values from 1-10
	  root.getChildren().add(new Label("Select quantity"));
      Spinner<Integer> spinnerQuantity = new Spinner<Integer>();
      final int defaultValue = 1;
      // Value factory.
      SpinnerValueFactory<Integer> quantityFactory =
         new SpinnerValueFactory.IntegerSpinnerValueFactory
                 (1, 10, defaultValue);
      spinnerQuantity.setValueFactory(quantityFactory);
      root.getChildren().add(spinnerQuantity);

      // Demonstrate ChoiceBox with delivery options
	  root.getChildren().add(new Label("Select delivery mode"));
	  ChoiceBox<String> cbModes = new ChoiceBox<String>(
		   FXCollections.observableArrayList("Delivery",
                                   "Dine-In", "Carryout"));
      root.getChildren().add(cbModes);

      // Button to display selections
	  Button btnSelections = new Button("Get Selections");
	  // Set the event handler when the button is clicked
	  btnSelections.setOnAction(new EventHandler<ActionEvent>()
	  {
	 	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		System.out.println("Hand tossed: " + rbHand.isSelected());
	   		System.out.println("Deep dish: " +
                       rbDeepDish.isSelected());
	   		System.out.println("Cheese: " + cbCheese.isSelected());
			System.out.println("Pepperoni: " +
                       cbPepperoni.isSelected());
			System.out.println("Mushrooms: " +
                       cbMushrooms.isSelected());
			System.out.println("Quantity: " +
                       spinnerQuantity.getValue());
			System.out.println("Mode: " + cbModes.getValue());
	   	}
	   }
	  );
	  root.getChildren().add(btnSelections);

 	  Scene scene = new Scene(root, 350, 300);
      primaryStage.setTitle("Additional Controls Demo");
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
