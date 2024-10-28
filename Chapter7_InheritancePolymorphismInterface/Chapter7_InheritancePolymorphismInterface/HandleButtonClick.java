import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
This class handles a button click and outputs a message.
The handle method is invoked when the button is clicked.
*/
public class HandleButtonClick implements EventHandler<ActionEvent>
{
	private String message;
	public HandleButtonClick()
	{
		message = "It is sunny!";
	}
	public HandleButtonClick(String customMessage)
	{
		message = customMessage;
	}
	@Override
	public void handle(ActionEvent event)
	{
        System.out.println(message);
    }
}

