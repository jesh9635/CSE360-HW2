package application;

import databasePart1.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class updateAnswerPage {
	private final DatabaseHelper databaseHelper; //Initialize the databaseHelper
	
	public updateAnswerPage(DatabaseHelper databaseHelper){ //Constructor for setting database
		this.databaseHelper = databaseHelper;
	}
	
	public void show (Stage primaryStage, User user, QuestionList qList, AnswerList aList){ //Main Method
		//Set the objects (Labels, Fields, Button)
		Label instructions = new Label("Update Answer Below");
	    Label postLabel = new Label("");
	    TextField answerNumber = new TextField();
	    answerNumber.setPromptText("Enter Answer Number to Update");
	    answerNumber.setMaxWidth(250);
        TextField description = new TextField();
        description.setPromptText("Enter Description");
        description.setMaxWidth(250);
        Button post = new Button("Update");
	    post.setOnAction (a -> {
	    	int aNumber = Integer.parseInt(answerNumber.getText()) - 1;
	    	String aDescription = description.getText();
	    	String aUser = user.getUserName();
	    	String postText = "";
	    	int size = aList.getList().size();
	    	if (size > 0 && aNumber < size) {
			    if (aList.getList().get(aNumber) != null) {
			    	aList.getList().get(aNumber).update(aList.getList().get(aNumber).read()[0], aDescription, aUser);
			    	postText = "Answer Updated";
			    } else {
			    	postText = "Error: Index out of bounds";
			    }	
	    	} else {
	    		postText = "Error: Index out of bounds";
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
        layout.getChildren().addAll(instructions,answerNumber, description, post, back, postLabel); //Place all objects (Labels, Fields, Button) in Layout	
	    Scene currScene = new Scene(layout, 800, 400); //Set window dimensions
	    
	    // Set the scene to primary stage
	    primaryStage.setScene(currScene);
	    primaryStage.setTitle("Create Question");
	}
}