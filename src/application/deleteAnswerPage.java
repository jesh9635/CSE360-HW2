package application;

import databasePart1.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class deleteAnswerPage {
	private final DatabaseHelper databaseHelper; //Initialize the databaseHelper
	
	public deleteAnswerPage(DatabaseHelper databaseHelper){ //Constructor for setting database
		this.databaseHelper = databaseHelper;
	}
	
	public void show (Stage primaryStage, User user, QuestionList qList, AnswerList aList){ //Main Method
		//Set the objects (Labels, Fields, Button)
		Label instructions = new Label("Delete Answer Below (Type the Number)");
	    Label postLabel = new Label("");
	    TextField answerNumber = new TextField();
	    answerNumber.setPromptText("Enter Answer Number to Delete");
	    answerNumber.setMaxWidth(250);
        Button delete = new Button("Delete");
	    delete.setOnAction (a -> {
	    	int size = aList.getList().size();
	    	String postText = "";
	    	int aNumber = Integer.parseInt(answerNumber.getText()) - 1;
	    	if (size > 0 && aNumber < size) {
			    if (aList.getList().get(aNumber) != null) {
			    	aList.delete(aNumber);
			    	postText = "Answer Deleted";
			    } else {
			    	postText = "Error: Invalid Answer Number";
			    }
	    	} else {
	    		postText = "Error: Invalid Answer Number";
	    	}
	    	postLabel.setText(postText);
		});
	    
        Button back = new Button("Back");
	    back.setOnAction (a -> {
	    	new WelcomeLoginPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	

		//Set the layout
	    VBox layout = new VBox(5); // Set Vertical Layout for children with int spacing
	    layout.setStyle("-fx-padding: 20; -fx-alignment: center;"); //Style the Layout
        layout.getChildren().addAll(instructions,answerNumber,delete, back, postLabel); //Place all objects (Labels, Fields, Button) in Layout	
	    Scene currScene = new Scene(layout, 800, 400); //Set window dimensions
	    
	    // Set the scene to primary stage
	    primaryStage.setScene(currScene);
	    primaryStage.setTitle("Create Question");
	}
}