package application;

import databasePart1.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class updateQuestionPage {
	private final DatabaseHelper databaseHelper; //Initialize the databaseHelper
	
	public updateQuestionPage(DatabaseHelper databaseHelper){ //Constructor for setting database
		this.databaseHelper = databaseHelper;
	}
	
	public void show (Stage primaryStage, User user, QuestionList qList, AnswerList aList){ //Main Method
		//Set the objects (Labels, Fields, Button)
		Label instructions = new Label("Update Question Below");
	    Label postLabel = new Label("");
	    TextField questionNumber = new TextField();
	    questionNumber.setPromptText("Enter Question Number to Update");
	    questionNumber.setMaxWidth(250);
        TextField title = new TextField();
        title.setPromptText("Enter Question");
        title.setMaxWidth(250);
        TextField description = new TextField();
        description.setPromptText("Enter Description");
        description.setMaxWidth(250);
        
        Button post = new Button("Update");
	    post.setOnAction (a -> {
	    	int qNumber = Integer.parseInt(questionNumber.getText()) - 1;
	    	String qTitle = title.getText();
	    	String qDescription = description.getText();
	    	String qUser = user.getUserName();
	    	String postText = "";
	    	int size = qList.getList().size();
	    	if (size > 0 && qNumber < size) {
			    if (qList.getList().get(qNumber) != null) {
			    	qList.getList().get(qNumber).update(qTitle, qDescription, qUser);
			    	postText = "Question Updated";
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
        layout.getChildren().addAll(instructions,questionNumber, title, description, post, back, postLabel); //Place all objects (Labels, Fields, Button) in Layout	
	    Scene currScene = new Scene(layout, 800, 400); //Set window dimensions
	    
	    // Set the scene to primary stage
	    primaryStage.setScene(currScene);
	    primaryStage.setTitle("Create Question");
	}
}