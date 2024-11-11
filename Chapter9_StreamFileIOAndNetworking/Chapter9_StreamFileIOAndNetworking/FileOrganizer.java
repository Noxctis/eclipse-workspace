import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileOrganizer extends Application
{
   private TextField fileNameField;
   private TextField firstLineField;

   public static void main(String[] args)
   {
      launch(args);
   }

   @Override
   public void start(Stage primaryStage) throws Exception
   {
      final int WIDTH = 400;
      final int HEIGHT = 300;
      final int NUMBER_OF_PIXELS = 300;

	  FlowPane root = new FlowPane();

	  Button showButton = new Button("Show first line");
	  root.getChildren().add(showButton);
	  showButton.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		showFirstLine();
	   	}
	   }
	  );

	  Button removeButton = new Button("Remove file");
	  root.getChildren().add(removeButton);
	  removeButton.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		removeFile();
	   	}
	   }
	  );

	  Button resetButton = new Button("Reset");
	  root.getChildren().add(resetButton);
	  resetButton.setOnAction(new EventHandler<ActionEvent>()
	   {
	   	@Override
	   	public void handle(ActionEvent event)
	   	{
	   		resetFields();
	   	}
	   }
	  );

	  fileNameField = new TextField("Enter file name here.");
	  fileNameField.setPrefWidth(NUMBER_OF_PIXELS);
	  root.getChildren().add(fileNameField);

	  firstLineField = new TextField();
	  firstLineField.setPrefWidth(NUMBER_OF_PIXELS);
	  root.getChildren().add(firstLineField);

   	  Scene scene = new Scene(root, WIDTH, HEIGHT);
      primaryStage.setTitle("File Organizer");
      primaryStage.setScene(scene);
      primaryStage.show();
   }

    private void showFirstLine( )
    {
        Scanner fileInput = null;
        String fileName = fileNameField.getText( );
        File fileObject = new File(fileName);

        if (!fileObject.exists( ))
            firstLineField.setText("No such file");
        else if (!fileObject.canRead( ))
            firstLineField.setText("That file is not readable.");
        else
        {
            try
            {
                fileInput = new Scanner(fileObject);
            }
            catch(FileNotFoundException e)
            {
                firstLineField.setText("Error opening the file " +
                                        fileName);
            }
            String firstLine = fileInput.nextLine( );
            firstLineField.setText(firstLine);
            fileInput.close( );
        }
    }

    private void resetFields()
    {
        fileNameField.setText("Enter file name here.");
        firstLineField.setText("");
    }

    private void removeFile( )
    {
        Scanner fileInput = null;
        String firstLine;
        String fileName = fileNameField.getText( );
        File fileObject = new File(fileName);

        if (!fileObject.exists( ))
            firstLineField.setText("No such file");
        else if (!fileObject.canWrite( ))
            firstLineField.setText("Permission denied.");
        else
        {
            if (fileObject.delete( ))
                firstLineField.setText("File deleted.");
            else
                firstLineField.setText("Could not delete file.");
        }
    }
}