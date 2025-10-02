package application;

import databasePart1.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class createAnswersPage {
	private final DatabaseHelper databaseHelper; //Initialize the databaseHelper
	
	public createAnswersPage(DatabaseHelper databaseHelper){ //Constructor for setting database
		this.databaseHelper = databaseHelper;
	}
	
	public void show (Stage primaryStage, User user, QuestionList qList, AnswerList aList){ //Main Method
		//Set the objects (Labels, Fields, Button)
		Label instructions = new Label("Create answer by entering the Question Number to respond to and your resopnse.");
	    Label postLabel = new Label("");
	    TextField questionNumber = new TextField();
	    questionNumber.setPromptText("Enter Question Number to respond to");
	    questionNumber.setMaxWidth(250);
        TextField description = new TextField();
        description.setPromptText("Enter Description");
        description.setMaxWidth(250);
        
        Button post = new Button("Post");
	    post.setOnAction (a -> {
	    	int qNumber = Integer.parseInt(questionNumber.getText()) - 1;
	    	String aDescription = description.getText();
	    	String aUser = user.getUserName();
	    	String postText = "";
	    	if (qList.getList().size() > 0 && qNumber < qList.getList().size()) {
			    if (qList.getList().get(qNumber) != null) {
			    	if (CharacterLengthEvaluator.evaluate(aDescription, "description") == true) {
				    	aList.add(new Answer(qList.getList().get(qNumber).read()[0], aDescription, aUser));
				    	postText = "Answer Posted";
			    	} else {
			    		postText = "Error: Characters not within limits";
			    	}
			    } else {
			    	postText = "Error: Invalid Index";
			    }
			    postLabel.setText(postText);
	    	}	    	
		});
	    
        Button back = new Button("Back");
	    back.setOnAction (a -> {
	    	new WelcomeLoginPage(databaseHelper).show(primaryStage, user, qList, aList);
		});
	

		//Set the layout
	    VBox layout = new VBox(5); // Set Vertical Layout for children with int spacing
	    layout.setStyle("-fx-padding: 20; -fx-alignment: center;"); //Style the Layout
        layout.getChildren().addAll(instructions,questionNumber, description, post, back, postLabel); //Place all objects (Labels, Fields, Button) in Layout	
	    Scene currScene = new Scene(layout, 800, 400); //Set window dimensions
	    
	    // Set the scene to primary stage
	    primaryStage.setScene(currScene);
	    primaryStage.setTitle("Create Question");
	}
}